package ewhacodic.demo.repository;

import ewhacodic.demo.domain.Board;
import ewhacodic.demo.domain.BoardComment;
import ewhacodic.demo.domain.TechComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TechCommentRepository extends JpaRepository<TechComment, Long> {
    List<TechComment> findBoardCommentsByPostId(Long postId);
    TechComment findByIdAndPostId(Long commentId, Long postId);
    void deleteBoardCommentByIdAndPostId(Long commentId, Long postId);
}
