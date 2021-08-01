package ewhacodic.demo.repository;

import ewhacodic.demo.domain.Board;
import ewhacodic.demo.domain.BoardComment;
import ewhacodic.demo.domain.Qna;
import ewhacodic.demo.domain.Tech;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TechRepository extends JpaRepository<Tech, Long> {
    List<Tech> findByTitleContaining(String keyword);
    List<Tech> findByTagContaining(String tag);
}
