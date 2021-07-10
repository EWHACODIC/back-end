package ewhacodic.demo.domain.userRank;

import ewhacodic.demo.domain.githubInfo.GithubInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


public interface UserRankRepository extends JpaRepository<UserRank, Long>, UserRankRepositoryCustom {

    Optional<UserRank> findByGithubInfoAndWeekAndLocalDate(GithubInfo githubInfo, boolean week, LocalDate localDate);

}
