package ewhacodic.demo.repository;

import ewhacodic.demo.domain.BoardComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;;

import java.util.List;

@Repository
public interface BoardCommentRepository extends JpaRepository<BoardComment, Long> {
    List<BoardComment> findBoardCommentsByPostId(Long postId);
    BoardComment findByIdAndPostId(Long commentId, Long postId);
    void deleteBoardCommentByIdAndPostId(Long commentId, Long postId);
}
