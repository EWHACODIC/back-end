package ewhacodic.demo.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity  //클래스와 테이블 매핑
@Table(name="COMMIT") //COMMIT 테이블과 매핑
@Getter
public class GithubInfo {

    @Id
    @Column(name = "id", unique = true) //user 테이블의 id와 연결하기 @OneToOne?
    private String userName;

    @Column(name = "github_name")
    private String githubName;

    @Column(name = "repo_name")
    private String repoName;

    @Column(name = "commits")
    private long commits;

    @Column(name = "ranking")
    private long ranking;

    @Builder
    public GithubInfo(String userName, String githubName, String repoName, long commits) {
        this.userName = userName;
        this.githubName = githubName;
        this.repoName = repoName;
        this.commits = commits;
    }
    //이제 할 일
    // 1. 여기에 commits 저장되게
    // 2. 커밋수로 자동으로 랭킹 갱신되게

}
