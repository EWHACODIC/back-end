package ewhacodic.demo.dto;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class UserInfoDto {
    private String userName;
    private String password;
    private String githubName;
    private String repoName;
    private String auth;

    public UserInfoDto(String userName, String password, String githubName, String repoName, String auth) {
        this.userName = userName;
        this.password = password;
        this.githubName = githubName;
        this.repoName = repoName;
        this.auth = auth;
    }
}