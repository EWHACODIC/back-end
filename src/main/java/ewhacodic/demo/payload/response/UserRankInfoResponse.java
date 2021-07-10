package ewhacodic.demo.payload.response;

import ewhacodic.demo.domain.githubInfo.GithubInfo;
import ewhacodic.demo.domain.userRank.UserRank;
import lombok.*;

import java.time.LocalDate;


@NoArgsConstructor
@Getter
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class UserRankInfoResponse {

    private long githubInfoId;

    private String authorId;

    private String name;

    private long score;

    private long commitCount;

    private long commitMaxCombo;

    private boolean week;

    private LocalDate localDate;

    private String profile;

    public static UserRankInfoResponse of(UserRank userRank, GithubInfo githubInfo) {
        return UserRankInfoResponse.builder()
                .githubInfoId(githubInfo.getInfoId())
                .authorId(githubInfo.getAuthorId())
                .score(userRank.getScore())
                .commitCount(userRank.getCommitCount())
                .commitMaxCombo(userRank.getCommitMaxCombo())
                .week(userRank.isWeek())
                .name(githubInfo.getUser().getName())
                .profile(githubInfo.getUser().getImageUrl())
                .localDate(userRank.getLocalDate())
                .build();
    }
}
