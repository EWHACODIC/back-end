package ewhacodic.demo.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;

@Getter
@Setter
@ToString
public class UserTagDto {
    private String userId;
    private Set<Long> tagIds;

    public UserTagDto() {
    }
}
