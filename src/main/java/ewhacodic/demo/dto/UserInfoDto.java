package ewhacodic.demo.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class UserInfoDto {
    private String userId;
    private String password;

    private String auth;
}
