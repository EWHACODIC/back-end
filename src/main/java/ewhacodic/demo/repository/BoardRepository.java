package ewhacodic.demo.repository;

import ewhacodic.demo.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


public interface BoardRepository extends JpaRepository<Board, Long> {
    List<Board> findByTitleContaining(String keyword);
}

