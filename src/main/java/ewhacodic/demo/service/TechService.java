package ewhacodic.demo.service;

import ewhacodic.demo.domain.Board;
import ewhacodic.demo.domain.Tech;
import ewhacodic.demo.domain.TechComment;
import ewhacodic.demo.domain.Tech;
import ewhacodic.demo.dto.BoardCommentDto;
import ewhacodic.demo.dto.BoardDto;
import ewhacodic.demo.dto.BoardListDto;
import ewhacodic.demo.repository.TechCommentRepository;
import ewhacodic.demo.repository.TechRepository;
import ewhacodic.demo.repository.TechCommentRepository;
import ewhacodic.demo.repository.TechRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
    private TechRepository techRepository;
    private TechCommentRepository techCommentRepository;

    public TechService(
            TechRepository techRepository,
            TechCommentRepository techCommentRepository
    ) {
        this.techRepository = techRepository;
        this.techCommentRepository = techCommentRepository;
    }

    public void savePost(BoardDto boardDto) {
        techRepository.save(boardDto.toTech());
    }

    @org.springframework.transaction.annotation.Transactional
    public void updatePost(Tech tech) {
        Optional<Tech> originalBoard = techRepository.findById(tech.getId());

        originalBoard.ifPresent(selectBoard -> {
            selectBoard.setId(tech.getId());
            selectBoard.setTitle(tech.getTitle());
            selectBoard.setComments(tech.getComments());
            selectBoard.setModifiedAt(LocalDateTime.now());
            selectBoard.setTag1(tech.getTag1());
            selectBoard.setTag2(tech.getTag2());
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
                .tag1(tech.getTag1())
                .tag2(tech.getTag2())
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

    public List<BoardListDto> getBoardListDto() {
        return techRepository.findAll().stream().map(BoardListDto::ofTech).collect(Collectors.toList());
    }

    public void updateBoardRecommend(Long id) {
        Optional<Tech> boardDto = techRepository.findById(id);
        boardDto.ifPresent(it -> {
            Tech tech = Tech.updateRecommend(it);
            techRepository.save(tech);
        });
    }

    public List<BoardListDto> searchPosts(String keyword) {
        List<Tech> boardList = techRepository.findByTitleContaining(keyword);

        return boardList.stream().map(BoardListDto::ofTech).collect(Collectors.toList());
    }

    public List<BoardListDto> searchPostsByTag(String tag){
        List<Tech> boardList = techRepository.findByTag1OrTag2(tag, tag);

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
                    .tag1(tech.getTag1())
                    .tag2(tech.getTag2())
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
}
