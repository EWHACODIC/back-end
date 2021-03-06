package ewhacodic.demo.domain;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity  //클래스와 테이블 매핑
@Table(name = "USER") //USER 테이블과 매핑
@Getter
@Setter
public class UserInfo implements UserDetails {

    @Id
    @Column(name = "code")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long code;

    @Column(name = "id", unique = true) // @ewhain.net
    private String userName;

    @Column(name = "password")
    private String password;

    @Column(name = "github_name")
    private String githubName;

    @Column(name = "repo_name")
    private String repoName;

    @Column(name = "auth")
    private String auth;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(
            name = "tag_ids",
            joinColumns = {
                    @JoinColumn(name = "user_code")
            }
    )
    @Column(name = "tag_ids", nullable = false)
    private Set<Long> tagIds;


    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(
            name = "board_ids",
            joinColumns = {
                    @JoinColumn(name = "user_code")
            }
    )
    @Column(name = "board_ids", nullable = false)
    private Set<Long> boardIds;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(
            name = "community_ids",
            joinColumns = {
                    @JoinColumn(name = "user_code")
            }
    )
    @Column(name = "community_ids", nullable = false)
    private Set<Long> communityIds;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(
            name = "qna_ids",
            joinColumns = {
                    @JoinColumn(name = "user_code")
            }
    )
    @Column(name = "qna_ids", nullable = false)
    private Set<Long> qnaIds;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(
            name = "tech_ids",
            joinColumns = {
                    @JoinColumn(name = "user_code")
            }
    )
    @Column(name = "tech_ids", nullable = false)
    private Set<Long> techIds;

    @Builder
    public UserInfo(
            String userName,
            String password,
            String githubName,
            String repoName,
            String auth,
            Set<Long> tagIds,
            Set<Long> communityIds,
            Set<Long> qnaIds,
            Set<Long> techIds) {
        this.userName = userName;
        this.password = password;
        this.githubName = githubName;
        this.repoName = repoName;
        this.auth = auth;
        this.tagIds = tagIds;
        this.communityIds = communityIds;
        this.qnaIds = qnaIds;
        this.techIds = techIds;
    }

    // 사용자의 권한을 콜렉션 형태로 반환
    // 단, 클래스 자료형은 GrantedAuthority를 구현해야함
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<GrantedAuthority> roles = new HashSet<>();

        for (String role : auth.split(",")) {
            roles.add(new SimpleGrantedAuthority(role));
        }

        return roles;
    }

    // 사용자의 이름 반환 (unique한 값)
    @Override
    public String getUsername() {
        return userName;
    }

    // 사용자의 password를 반환
    @Override
    public String getPassword() {
        return password;
    }

    // 계정 만료 여부 반환
    @Override
    public boolean isAccountNonExpired() {
        // 만료되었는지 확인하는 로직
        return true; // true -> 만료되지 않았음
    }

    // 계정 잠금 여부 반환
    @Override
    public boolean isAccountNonLocked() {
        // 계정 잠금되었는지 확인하는 로직
        return true; // true -> 잠금되지 않았음
    }

    // 패스워드의 만료 여부 반환
    @Override
    public boolean isCredentialsNonExpired() {
        // 패스워드가 만료되었는지 확인하는 로직
        return true; // true -> 만료되지 않았음
    }

    // 계정 사용 가능 여부 반환
    @Override
    public boolean isEnabled() {
        // 계정이 사용 가능한지 확인하는 로직
        return true; // true -> 사용 가능
    }
}