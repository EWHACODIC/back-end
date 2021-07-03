package ewhacodic.demo.repository;

import ewhacodic.demo.domain.Board;
import ewhacodic.demo.domain.Tech;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TechRepository extends JpaRepository<Tech, Long> {
}
