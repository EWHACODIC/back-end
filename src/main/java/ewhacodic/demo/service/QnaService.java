package ewhacodic.demo.service;

import ewhacodic.demo.domain.*;
import ewhacodic.demo.dto.BoardCommentDto;
import ewhacodic.demo.dto.BoardDto;
import ewhacodic.demo.dto.BoardListDto;
import ewhacodic.demo.repository.BoardCommentRepository;
import ewhacodic.demo.repository.BoardRepository;
import ewhacodic.demo.repository.QnaCommentRepository;
import ewhacodic.demo.repository.QnaRepository;
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
public class QnaService {
    @Autowired
    private QnaRepository qnaRepository;
    private QnaCommentRepository qnaCommentRepository;

    public QnaService(
            QnaRepository qnaRepository,
            QnaCommentRepository qnaCommentRepository
    ) {
        this.qnaRepository = qnaRepository;
        this.qnaCommentRepository = qnaCommentRepository;
    }

    public void savePost(BoardDto boardDto) {
        qnaRepository.save(boardDto.toQna());
    }

    @org.springframework.transaction.annotation.Transactional
    public void updatePost(Qna qna) {
        Optional<Qna> originalBoard = qnaRepository.findById(qna.getId());

        originalBoard.ifPresent(selectBoard -> {
            selectBoard.setId(qna.getId());
            selectBoard.setTitle(qna.getTitle());
            selectBoard.setComments(qna.getComments());
            selectBoard.setModifiedAt(LocalDateTime.now());
            selectBoard.setTag1(qna.getTag1());
            selectBoard.setTag2(qna.getTag2());
            selectBoard.setUserCode(qna.getUserCode());
            selectBoard.setComments(selectBoard.getComments());
            qnaRepository.save(selectBoard);
        });
    }


    public BoardDto getPostOnly(Long id) {
        Optional<Qna> boardWrapper = qnaRepository.findById(id);
        Qna qna = boardWrapper.get();

        BoardDto boardDto = BoardDto.builder()
                .id(qna.getId())
                .title(qna.getTitle())
                .content(qna.getContent())
                .tag1(qna.getTag1())
                .tag2(qna.getTag2())
                .view(qna.getView())
                .userCode(qna.getUserCode())
                .createDate(qna.getCreatedAt())
                .modifiedDate(qna.getModifiedAt())
                .build();

        qna.updateView();

        return boardDto;
    }

    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    public List<QnaComment> getCommentByPostId(Long postId) {
        return qnaCommentRepository.findBoardCommentsByPostId(postId);
    }

    public Qna getPostAndComment(Long id) {
        return qnaRepository.findById(id).get();
    }

    public List<BoardListDto> getBoardListDto(Pageable pageable) {
        return qnaRepository.findAll(pageable).stream().map(BoardListDto::ofQna).collect(Collectors.toList());
    }

    public void updateBoardRecommend(Long id) {
        Optional<Qna> boardDto = qnaRepository.findById(id);
        boardDto.ifPresent(it -> {
            Qna qna = Qna.updateRecommend(it);
            qnaRepository.save(qna);
        });
    }

    public List<BoardListDto> searchPosts(String keyword) {
        List<Qna> boardList = qnaRepository.findByTitleContaining(keyword);

        return boardList.stream().map(BoardListDto::ofQna).collect(Collectors.toList());
    }

    public List<BoardListDto> searchPostsByTag(String tag){
        List<Qna> boardList = qnaRepository.findByTag1OrTag2(tag, tag);

        return boardList.stream().map(BoardListDto::ofQna).collect(Collectors.toList());
    }

    @org.springframework.transaction.annotation.Transactional
    public List<BoardDto> getBoardList(String order){
        List<Qna> boardList;
        if(order.equals("latest")){
            boardList = qnaRepository.findAll(Sort.by(Sort.Direction.DESC, "createdAt"));
        } else if(order.equals("recommend")){
            boardList = qnaRepository.findAll(Sort.by(Sort.Direction.DESC, "recommend"));
        } else if(order.equals("view")){
            boardList = qnaRepository.findAll(Sort.by(Sort.Direction.DESC, "view"));
        } else if(order.equals("reply")){
            boardList = qnaRepository.findAll(Sort.by(Sort.Direction.DESC, "comments.createdAt")).stream().distinct().collect(Collectors.toList());
        } else {
            boardList = qnaRepository.findAll();
        }
        List<BoardDto> boardDtoList = new ArrayList<>();

        for(Qna qna:boardList){
            BoardDto boardDto = BoardDto.builder()
                    .id(qna.getId())
                    .title(qna.getTitle())
                    .content(qna.getContent())
                    .tag1(qna.getTag1())
                    .tag2(qna.getTag2())
                    .view(qna.getView())
                    .recommend(qna.getRecommend())
                    .userCode(qna.getUserCode())
                    .createDate(qna.getCreatedAt())
                    .modifiedDate(qna.getModifiedAt())
                    .build();

            boardDtoList.add(boardDto);
        }

        return boardDtoList;
    }

    @org.springframework.transaction.annotation.Transactional
    public void deletePost(Long id) {
        qnaRepository.deleteById(id);
    }

    public void saveComment(BoardCommentDto boardCommentDto, Long postId) {
        QnaComment qnaComment = QnaComment.of(boardCommentDto, postId);
        qnaCommentRepository.save(qnaComment);
    }

    public void updateComment(Long postId, Long commentId, BoardCommentDto boardCommentDto) {
        QnaComment originalBoardComment = qnaCommentRepository.findByIdAndPostId(commentId, postId);
        originalBoardComment.setContent(boardCommentDto.getContent());
        qnaCommentRepository.save(originalBoardComment);

    }

    public void deleteComment(Long commentId, Long postId) {
        qnaCommentRepository.deleteBoardCommentByIdAndPostId(commentId, postId);
    }

    public Qna updateCommentCount(Long postId) {
        Optional<Qna> qna = qnaRepository.findById(postId);
        qna.ifPresent(Qna::renewCommentCount);
        return qna.get();
    }
}
