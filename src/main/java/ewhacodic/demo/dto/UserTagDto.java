package ewhacodic.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;

@Getter
@Setter
@ToString
public class UserTagDto {
    private Set<Long> tagIds;
    private Set<TagDto> tagDtos;

    public UserTagDto() {
    }
}
