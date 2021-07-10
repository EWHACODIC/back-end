package ewhacodic.demo.service;

import ewhacodic.demo.domain.Board;
import ewhacodic.demo.domain.BoardComment;
import ewhacodic.demo.domain.Community;
import ewhacodic.demo.domain.CommunityComment;
import ewhacodic.demo.dto.BoardCommentDto;
import ewhacodic.demo.dto.BoardDto;
import ewhacodic.demo.dto.BoardListDto;
import ewhacodic.demo.repository.BoardCommentRepository;
import ewhacodic.demo.repository.BoardRepository;
import ewhacodic.demo.repository.CommunityCommentRepository;
import ewhacodic.demo.repository.CommunityRepository;
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
public class CommunityService {
    @Autowired
    private CommunityRepository communityRepository;
    private CommunityCommentRepository communityCommentRepository;

    public CommunityService(
            CommunityRepository communityRepository,
            CommunityCommentRepository communityCommentRepository
    ) {
        this.communityRepository = communityRepository;
        this.communityCommentRepository = communityCommentRepository;
    }

    public void savePost(BoardDto boardDto) {
        communityRepository.save(boardDto.toCommunity());
    }

    @org.springframework.transaction.annotation.Transactional
    public void updatePost(Community community) {
        Optional<Community> originalBoard = communityRepository.findById(community.getId());

        originalBoard.ifPresent(selectBoard -> {
            selectBoard.setId(community.getId());
            selectBoard.setTitle(community.getTitle());
            selectBoard.setComments(community.getComments());
            selectBoard.setModifiedAt(LocalDateTime.now());
            selectBoard.setTag(community.getTag());
            selectBoard.setUserCode(community.getUserCode());
            selectBoard.setComments(selectBoard.getComments());
            communityRepository.save(selectBoard);
        });
    }


    public BoardDto getPostOnly(Long id) {
        Optional<Community> boardWrapper = communityRepository.findById(id);
        Community community = boardWrapper.get();

        BoardDto boardDto = BoardDto.builder()
                .id(community.getId())
                .title(community.getTitle())
                .content(community.getContent())
                .tag(community.getTag())
                .view(community.getView())
                .userCode(community.getUserCode())
                .createDate(community.getCreatedAt())
                .modifiedDate(community.getModifiedAt())
                .build();

        community.updateView();

        return boardDto;
    }

    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    public List<CommunityComment> getCommentByPostId(Long postId) {
        return communityCommentRepository.findBoardCommentsByPostId(postId);
    }

    public Community getPostAndComment(Long id) {
        return communityRepository.findById(id).get();
    }

    public List<BoardListDto> getBoardListDto() {
        return communityRepository.findAll().stream().map(BoardListDto::ofCommunity).collect(Collectors.toList());
    }

    public void updateBoardRecommend(Long id) {
        Optional<Community> boardDto = communityRepository.findById(id);
        boardDto.ifPresent(it -> {
            Community community = Community.updateRecommend(it);
            communityRepository.save(community);
        });
    }

    public List<BoardListDto> searchPosts(String keyword) {
        List<Community> boardList = communityRepository.findByTitleContaining(keyword);

        return boardList.stream().map(BoardListDto::ofCommunity).collect(Collectors.toList());
    }

    @org.springframework.transaction.annotation.Transactional
    public List<BoardDto> getBoardList(String order){
        List<Community> boardList;
        if(order.equals("latest")){
            boardList = communityRepository.findAll(Sort.by(Sort.Direction.DESC, "createdAt"));
        } else if(order.equals("recommend")){
            boardList = communityRepository.findAll(Sort.by(Sort.Direction.DESC, "recommend"));
        } else if(order.equals("view")){
            boardList = communityRepository.findAll(Sort.by(Sort.Direction.DESC, "view"));
        } else if(order.equals("reply")){
            boardList = communityRepository.findAll(Sort.by(Sort.Direction.DESC, "comments.createdAt")).stream().distinct().collect(Collectors.toList());
        } else {
            boardList = communityRepository.findAll();
        }
        List<BoardDto> boardDtoList = new ArrayList<>();

        for(Community community:boardList){
            BoardDto boardDto = BoardDto.builder()
                    .id(community.getId())
                    .title(community.getTitle())
                    .content(community.getContent())
                    .tag(community.getTag())
                    .view(community.getView())
                    .recommend(community.getRecommend())
                    .userCode(community.getUserCode())
                    .createDate(community.getCreatedAt())
                    .modifiedDate(community.getModifiedAt())
                    .build();

            boardDtoList.add(boardDto);
        }

        return boardDtoList;
    }

    @org.springframework.transaction.annotation.Transactional
    public void deletePost(Long id) {
        communityRepository.deleteById(id);
    }

    public void saveComment(BoardCommentDto boardCommentDto, Long postId) {
        CommunityComment communityComment = CommunityComment.of(boardCommentDto, postId);
        communityCommentRepository.save(communityComment);
    }

    public void updateComment(Long postId, Long commentId, BoardCommentDto boardCommentDto) {
        CommunityComment originalBoardComment = communityCommentRepository.findByIdAndPostId(commentId, postId);
        originalBoardComment.setContent(boardCommentDto.getContent());
        communityCommentRepository.save(originalBoardComment);

    }

    public void deleteComment(Long commentId, Long postId) {
        communityCommentRepository.deleteBoardCommentByIdAndPostId(commentId, postId);
    }
}
