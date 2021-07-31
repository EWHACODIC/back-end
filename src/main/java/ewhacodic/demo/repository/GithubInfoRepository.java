package ewhacodic.demo.repository;

import ewhacodic.demo.domain.GithubInfo;
import ewhacodic.demo.domain.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GithubInfoRepository extends JpaRepository<GithubInfo, String> {
    Optional<GithubInfo> findByUserName(String userName);
}
