package ewhacodic.demo.dto;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class UserInfoDto {
    private String userName;
    private String password;
    private String auth;
    private String email;
    public UserInfoDto(String userName, String email, String password, String auth) {
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.auth = auth;
    }

    public String getEmail() {
        return email;
    }

   // public String getAuthKey() { }

    //public static void setAuthKey(String authKey) { }
}
