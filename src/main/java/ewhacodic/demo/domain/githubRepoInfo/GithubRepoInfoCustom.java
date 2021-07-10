package ewhacodic.demo.domain.githubRepoInfo;

import java.time.LocalDateTime;
import java.util.List;


public interface GithubRepoInfoCustom {
    List<GithubRepoInfo> findBetweenTime(LocalDateTime startTime, LocalDateTime endTime, Long githubRepoInfoId);
}
