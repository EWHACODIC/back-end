package ewhacodic.demo.payload.response;

import lombok.*;

import java.time.LocalDateTime;


@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder(access = AccessLevel.PRIVATE)
public class GithubCommitInfoResponse {
    private String sha;
    private String htmlUrl;
    private String commitMessage;
    private LocalDateTime date;

    public static GithubCommitInfoResponse of(GithubCommitInfo commitInfo) {
        return GithubCommitInfoResponse.builder()
                .sha(commitInfo.getSha())
                .htmlUrl(commitInfo.getHtmlUrl())
                .commitMessage(commitInfo.getCommitMessage())
                .date(commitInfo.getDate())
                .build();
    }

}
