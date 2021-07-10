package cewhacodic.demo.domain.githubInfo;

import java.util.Optional;


public interface GithubInfoCustom {

    Optional<GithubInfo> findByUserSubId(String subId);

    Optional<GithubInfo> findByUserId(Long userId);
}
