package ewhacodic.demo.dto;

import ewhacodic.demo.domain.Community;
import ewhacodic.demo.domain.GithubInfo;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CommitDto {
    private String userName;
    private Long commitCount;
    private Long rank;

    @Builder
    public CommitDto(String userName, Long commitCount, Long rank) {
        this.userName = userName;
        this.commitCount= commitCount;
        this.rank = rank;
    }

    public static CommitDto of(GithubInfo githubInfo, Long rank) {
        return CommitDto.builder()
                .userName(githubInfo.getUserName())
                .commitCount(githubInfo.getCommits())
                .rank(rank)
                .build();
    }
}
