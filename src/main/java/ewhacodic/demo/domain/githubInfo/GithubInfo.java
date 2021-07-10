package ewhacodic.demo.githubInfo;

import ewhacodic.demo.domain.BaseTime;
import ewhacodic.demo.domain.user.User;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;


@Entity
@Getter
@NoArgsConstructor
@Builder(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@DynamicUpdate
public class GithubInfo extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long infoId;

    @Setter
    private String name;

    private String authorId;

    private String email;

    @Setter
    private String imageUrl;

    private Long providerId;

    @Setter
    private String token;

    @OneToOne
    @JoinColumn(name = "userId")
    @NotNull
    private User user;

    public String getToken() {
        return "token " + token;
    }

}
