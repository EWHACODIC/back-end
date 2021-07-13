package ewhacodic.demo.repository;

import ewhacodic.demo.domain.Board;
import ewhacodic.demo.domain.BoardComment;
import ewhacodic.demo.domain.QnaComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QnaCommentRepository extends JpaRepository<QnaComment, Long> {
    List<QnaComment> findBoardCommentsByPostId(Long postId);
    QnaComment findByIdAndPostId(Long commentId, Long postId);
    void deleteBoardCommentByIdAndPostId(Long commentId, Long postId);
}