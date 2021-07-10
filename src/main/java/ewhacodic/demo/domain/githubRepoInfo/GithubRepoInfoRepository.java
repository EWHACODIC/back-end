package ewhacodic.demo.domain.githubRepoInfo;

import org.springframework.data.jpa.repository.JpaRepository;


public interface GithubRepoInfoRepository extends JpaRepository<GithubRepoInfo, Long>, GithubRepoInfoCustom {

}
