package ewhacodic.demo.repository;

import ewhacodic.demo.domain.Board;
import ewhacodic.demo.domain.TechComment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TechCommentRepository extends JpaRepository<TechComment, Long> {
}
