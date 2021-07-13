package ewhacodic.demo.repository;

import ewhacodic.demo.domain.Board;
import ewhacodic.demo.domain.BoardComment;
import ewhacodic.demo.domain.CommunityComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CommunityCommentRepository extends JpaRepository<CommunityComment, Long> {
    List<CommunityComment> findBoardCommentsByPostId(Long postId);
    CommunityComment findByIdAndPostId(Long commentId, Long postId);
    void deleteBoardCommentByIdAndPostId(Long commentId, Long postId);
}
