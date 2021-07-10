package ewhacodic.demo.domain.githubRepoInfo;

import ewhacodic.demo.domain.BaseTime;
import ewhacodic.demo.domain.githubInfo.GithubInfo;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Getter
@NoArgsConstructor
@Builder(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@DynamicUpdate
@ToString
public class GithubRepoInfo {

    @Id
    private long repoInfoId;

    private String name;
    private String owner;
    private String htmlUrl;
    private String description;
    private String language;
    private int stargazersCount;
    private int watchersCount;
    private int forksCount;

    @Setter
    private long additions;
    @Setter
    private long deletions;
    @Setter
    private long commits;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "infoId")
    private GithubInfo githubInfo;

}
