package ewhacodic.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class UserInfoDto {
    private String userName;
    private String password;

    private String auth;
}
