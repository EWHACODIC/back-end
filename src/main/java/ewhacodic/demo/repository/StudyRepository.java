package ewhacodic.demo.repository;

import ewhacodic.demo.domain.Study;
import ewhacodic.demo.dto.StudyDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudyRepository extends JpaRepository<Study, Long> {
}
