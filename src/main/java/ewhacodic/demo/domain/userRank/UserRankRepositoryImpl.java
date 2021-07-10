package ewhacodic.demo.domain.userRank;

import ewhacodic.demo.domain.githubInfo.QGithubInfo;
import ewhacodic.demo.domain.user.QUser;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.List;


@RequiredArgsConstructor
public class UserRankRepositoryImpl implements UserRankRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<UserRank> findAllUserRankings(boolean week, LocalDate localDate) {
        return jpaQueryFactory.selectFrom(QUserRank.userRank)
                .where(QUserRank.userRank.week.eq(week))
                .where(QUserRank.userRank.localDate.eq(localDate))
                .join(QUserRank.userRank.githubInfo, QGithubInfo.githubInfo).fetchJoin()
                .join(QGithubInfo.githubInfo.user, QUser.user).fetchJoin()
                .orderBy(QUserRank.userRank.score.desc())
                .fetch();
    }
}
