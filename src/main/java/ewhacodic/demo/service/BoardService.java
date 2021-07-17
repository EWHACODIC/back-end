package ewhacodic.demo.service;

import ewhacodic.demo.domain.Board;
import ewhacodic.demo.domain.BoardComment;
import ewhacodic.demo.dto.BoardCommentDto;
import ewhacodic.demo.dto.BoardDto;
import ewhacodic.demo.dto.BoardListDto;
import ewhacodic.demo.repository.BoardCommentRepository;
import ewhacodic.demo.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class BoardService {
    @Autowired
    private BoardRepository boardRepository;
    private BoardCommentRepository boardCommentRepository;

    public BoardService(
            BoardRepository boardRepository,
            BoardCommentRepository boardCommentRepository
    ) {
        this.boardRepository = boardRepository;
        this.boardCommentRepository = boardCommentRepository;
    }

    public void savePost(BoardDto boardDto) {
        boardRepository.save(boardDto.toEntity());
    }

    @Transactional
    public void updatePost(Board board) {
        Optional<Board> originalBoard = boardRepository.findById(board.getId());

        originalBoard.ifPresent(selectBoard -> {
            selectBoard.setId(board.getId());
            selectBoard.setTitle(board.getTitle());
            selectBoard.setComments(board.getComments());
            selectBoard.setModifiedAt(LocalDateTime.now());
            selectBoard.setTag1(board.getTag1());
            selectBoard.setTag2(board.getTag2());
            selectBoard.setUserCode(board.getUserCode());
            selectBoard.setComments(selectBoard.getComments());
            boardRepository.save(selectBoard);
        });
    }


    public BoardDto getPostOnly(Long id) {
        Optional<Board> boardWrapper = boardRepository.findById(id);
        Board board = boardWrapper.get();

        BoardDto boardDto = BoardDto.builder()
                .id(board.getId())
                .title(board.getTitle())
                .content(board.getContent())
                .tag1(board.getTag1())
                .tag2(board.getTag2())
                .view(board.getView())
                .userCode(board.getUserCode())
                .createDate(board.getCreatedAt())
                .modifiedDate(board.getModifiedAt())
                .build();

        board.updateView();

        return boardDto;
    }

    @Transactional(readOnly = true)
    public List<BoardComment> getCommentByPostId(Long postId) {
        return boardCommentRepository.findBoardCommentsByPostId(postId);
    }

    public Board getPostAndComment(Long id) {
        return boardRepository.findById(id).get();
    }

    public List<BoardListDto> getBoardListDto() {
        return boardRepository.findAll().stream().map(BoardListDto::of).collect(Collectors.toList());
    }

    public void updateBoardRecommend(Long id) {
        Optional<Board> boardDto = boardRepository.findById(id);
        boardDto.ifPresent(it -> {
            Board board = Board.updateRecommend(it);
            boardRepository.save(board);
        });
    }

    public List<BoardListDto> searchPosts(String keyword) {
        List<Board> boardList = boardRepository.findByTitleContaining(keyword);

        return boardList.stream().map(BoardListDto::of).collect(Collectors.toList());
    }

    public List<BoardListDto> searchPostsByTag(String tag){
        List<Board> boardList = boardRepository.findByTag1OrTag2(tag, tag);

        return boardList.stream().map(BoardListDto::of).collect(Collectors.toList());
    }

    @Transactional
    public List<BoardDto> getBoardList(String order){
        List<Board> boardList;
        if(order.equals("latest")){
            boardList = boardRepository.findAll(Sort.by(Sort.Direction.DESC, "createdAt"));
        } else if(order.equals("recommend")){
            boardList = boardRepository.findAll(Sort.by(Sort.Direction.DESC, "recommend"));
        } else if(order.equals("view")){
            boardList = boardRepository.findAll(Sort.by(Sort.Direction.DESC, "view"));
        } else if(order.equals("reply")){
            boardList = boardRepository.findAll(Sort.by(Sort.Direction.DESC, "comments.createdAt")).stream().distinct().collect(Collectors.toList());
        } else {
            boardList = boardRepository.findAll();
        }
        List<BoardDto> boardDtoList = new ArrayList<>();

        for(Board board:boardList){
            BoardDto boardDto = BoardDto.builder()
                    .id(board.getId())
                    .title(board.getTitle())
                    .content(board.getContent())
                    .tag1(board.getTag1())
                    .tag2(board.getTag2())
                    .view(board.getView())
                    .recommend(board.getRecommend())
                    .userCode(board.getUserCode())
                    .createDate(board.getCreatedAt())
                    .modifiedDate(board.getModifiedAt())
                    .build();

            boardDtoList.add(boardDto);
        }

        return boardDtoList;
    }

    @Transactional
    public void deletePost(Long id) {
        boardRepository.deleteById(id);
    }

    public void saveComment(BoardCommentDto boardCommentDto, Long postId) {
        BoardComment boardComment = BoardComment.of(boardCommentDto, postId);
        boardCommentRepository.save(boardComment);
    }

    public void updateComment(Long postId, Long commentId, BoardCommentDto boardCommentDto) {
        BoardComment originalBoardComment = boardCommentRepository.findByIdAndPostId(commentId, postId);
        originalBoardComment.setContent(boardCommentDto.getContent());
        boardCommentRepository.save(originalBoardComment);

    }

    public void deleteComment(Long commentId, Long postId) {
        boardCommentRepository.deleteBoardCommentByIdAndPostId(commentId, postId);
    }


}
