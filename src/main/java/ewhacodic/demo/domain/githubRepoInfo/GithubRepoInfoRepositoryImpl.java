package ewhacodic.demo.domain.githubRepoInfo;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;


@RequiredArgsConstructor
public class GithubRepoInfoRepositoryImpl implements GithubRepoInfoCustom {

    private final JPAQueryFactory jpaQueryFactory;

    // 안씀
    @Override
    public List<GithubRepoInfo> findBetweenTime(LocalDateTime startTime, LocalDateTime endTime, Long githubRepoInfoId) {
        return jpaQueryFactory.selectFrom(QGithubRepoInfo.githubRepoInfo)
                .where(QGithubRepoInfo.githubRepoInfo.updatedAt.between(startTime, endTime))
                .fetch();
    }
}
