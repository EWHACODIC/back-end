package ewhacodic.demo.dto;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class UserInfoDto {
    private String userName;
    private String password;
    private String auth;
    String email=userName+"@ewhain.net"; //그냥

    public static String getEmail() {
        return email;
    }

    public static String getAuthKey() {

    }

    public static void setAuthKey(String authKey) {

    }
}
