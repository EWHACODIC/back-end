package ewhacodic.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class UserInfoDto {
    private String userName;
    private String id;
    private String password;

    private String auth;
}
