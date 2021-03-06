package ewhacodic.demo.service;

import com.google.gson.Gson;
import ewhacodic.demo.domain.*;
import ewhacodic.demo.domain.Tech;
import ewhacodic.demo.dto.BoardCommentDto;
import ewhacodic.demo.dto.BoardDto;
import ewhacodic.demo.dto.BoardListDto;
import ewhacodic.demo.repository.*;
import ewhacodic.demo.repository.TechCommentRepository;
import ewhacodic.demo.repository.TechRepository;
import org.h2.engine.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class TechService {
    @Autowired
    private final TechRepository techRepository;
    private final TechCommentRepository techCommentRepository;
    private final UserRepository userRepository;
    private Gson gsonObj = new Gson();

    public TechService(
            TechRepository techRepository,
            TechCommentRepository techCommentRepository,
            UserRepository userRepository
    ) {
        this.techRepository = techRepository;
        this.techCommentRepository = techCommentRepository;
        this.userRepository = userRepository;
    }

    public void savePost(BoardDto boardDto) {
        techRepository.save(boardDto.toTech());
    }

    @org.springframework.transaction.annotation.Transactional
    public void updatePost(BoardDto tech) {
        Optional<Tech> originalBoard = techRepository.findById(tech.getId());

        originalBoard.ifPresent(selectBoard -> {
            selectBoard.setId(tech.getId());
            selectBoard.setTitle(tech.getTitle());
            selectBoard.setContent(tech.getContent());
            selectBoard.setModifiedAt(LocalDateTime.now());
            selectBoard.setTag(gsonObj.toJson(tech.getTag()));
            selectBoard.setUserCode(tech.getUserCode());
            selectBoard.setComments(selectBoard.getComments());
            techRepository.save(selectBoard);
        });
    }


    public BoardDto getPostOnly(Long id) {
        Optional<Tech> boardWrapper = techRepository.findById(id);
        Tech tech = boardWrapper.get();

        BoardDto boardDto = BoardDto.builder()
                .id(tech.getId())
                .title(tech.getTitle())
                .content(tech.getContent())
                .tag(gsonObj.fromJson(tech.getTag(), List.class))
                .view(tech.getView())
                .userCode(tech.getUserCode())
                .createDate(tech.getCreatedAt())
                .modifiedDate(tech.getModifiedAt())
                .build();

        tech.updateView();

        return boardDto;
    }

    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    public List<TechComment> getCommentByPostId(Long postId) {
        return techCommentRepository.findBoardCommentsByPostId(postId);
    }

    public Tech getPostAndComment(Long id) {
        return techRepository.findById(id).get();
    }

    public List<BoardListDto> getBoardListDto(Pageable pageable) {
        return techRepository.findAll(pageable).stream().map(BoardListDto::ofTech).collect(Collectors.toList());
    }

    public void updateBoardRecommend(Long id, Long userCode) {
        UserInfo userInfo = userRepository.findOneByCode(userCode);
        Optional<Tech> boardDto = techRepository.findById(id);
        boardDto.ifPresent(it -> {
            Tech tech = Tech.updateRecommend(it);
            userInfo.getTechIds().add(tech.getId());
            techRepository.save(tech);
            userRepository.save(userInfo);
        });
    }

    public List<BoardListDto> searchPosts(String keyword) {
        List<Tech> boardList = techRepository.findByTitleContaining(keyword);

        return boardList.stream().map(BoardListDto::ofTech).collect(Collectors.toList());
    }

    public List<BoardListDto> searchPostsByTag(String tag){
        List<Tech> boardList = techRepository.findByTagContaining(tag);

        return boardList.stream().map(BoardListDto::ofTech).collect(Collectors.toList());
    }

    @org.springframework.transaction.annotation.Transactional
    public List<BoardDto> getBoardList(String order){
        List<Tech> boardList;
        if(order.equals("latest")){
            boardList = techRepository.findAll(Sort.by(Sort.Direction.DESC, "createdAt"));
        } else if(order.equals("recommend")){
            boardList = techRepository.findAll(Sort.by(Sort.Direction.DESC, "recommend"));
        } else if(order.equals("view")){
            boardList = techRepository.findAll(Sort.by(Sort.Direction.DESC, "view"));
        } else if(order.equals("reply")){
            boardList = techRepository.findAll(Sort.by(Sort.Direction.DESC, "comments.createdAt")).stream().distinct().collect(Collectors.toList());
        } else {
            boardList = techRepository.findAll();
        }
        List<BoardDto> boardDtoList = new ArrayList<>();

        for(Tech tech:boardList){
            BoardDto boardDto = BoardDto.builder()
                    .id(tech.getId())
                    .title(tech.getTitle())
                    .content(tech.getContent())
                    .tag(gsonObj.fromJson(tech.getTag(), List.class))
                    .view(tech.getView())
                    .recommend(tech.getRecommend())
                    .userCode(tech.getUserCode())
                    .createDate(tech.getCreatedAt())
                    .modifiedDate(tech.getModifiedAt())
                    .build();

            boardDtoList.add(boardDto);
        }

        return boardDtoList;
    }

    @org.springframework.transaction.annotation.Transactional
    public void deletePost(Long id) {
        techRepository.deleteById(id);
    }

    public void saveComment(BoardCommentDto boardCommentDto, Long postId) {
        TechComment techComment = TechComment.of(boardCommentDto, postId);
        techCommentRepository.save(techComment);
    }

    public void updateComment(Long postId, Long commentId, BoardCommentDto boardCommentDto) {
        TechComment originalBoardComment = techCommentRepository.findByIdAndPostId(commentId, postId);
        originalBoardComment.setContent(boardCommentDto.getContent());
        techCommentRepository.save(originalBoardComment);

    }

    public void deleteComment(Long commentId, Long postId) {
        techCommentRepository.deleteBoardCommentByIdAndPostId(commentId, postId);
    }

    public Tech updateCommentCount(Long postId) {
        Optional<Tech> tech = techRepository.findById(postId);
        tech.ifPresent(Tech::renewCommentCount);
        return tech.get();
    }

    public Long totalPosts(List<BoardListDto> boardListDtos){
        return boardListDtos.stream().count();
    }

    public Long totalPosts() {
        return techRepository.findAll().stream().count();
    }
}
