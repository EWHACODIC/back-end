package ewhacodic.demo.repository;

import ewhacodic.demo.domain.Board;
import ewhacodic.demo.domain.QnaComment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QnaCommentRepository extends JpaRepository<QnaComment, Long> {
}
