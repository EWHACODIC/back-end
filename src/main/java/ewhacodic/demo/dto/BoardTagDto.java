package ewhacodic.demo.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;

@Getter
@Setter
@ToString
public class BoardTagDto {
    private Set<Long> tagIds;
    private Set<TagDto> tagDtos;

    public BoardTagDto(){

    }
}
