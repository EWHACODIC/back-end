package ewhacodic.demo.repository;

import ewhacodic.demo.domain.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends JpaRepository<Tag, Long> {
    Tag findOneById(Long id);
    Tag findOneByTagName(String tagName);
}
