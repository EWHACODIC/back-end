package ewhacodic.demo.payload.response;

import ewhacodic.demo.domain.githubInfo.GithubInfo;
import lombok.*;


@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder(access = AccessLevel.PRIVATE)
public class GithubDetailInfoResponse {

    private String name;
    private String email;
    private String imageUrl;
    private Long providerId;
    private String authorId;

    public static GithubDetailInfoResponse fromEntity(GithubInfo githubInfo) {
        return GithubDetailInfoResponse.builder()
                .name(githubInfo.getName())
                .email(githubInfo.getEmail())
                .imageUrl(githubInfo.getImageUrl())
                .authorId(githubInfo.getAuthorId())
                .providerId(githubInfo.getProviderId()).build();
    }

}
