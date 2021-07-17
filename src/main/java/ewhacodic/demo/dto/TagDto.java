package ewhacodic.demo.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class TagDto {
    Long tagId;
    String tagName;

    @Builder
    public TagDto(Long tagId, String tagName) {
        this.tagId = tagId;
        this.tagName = tagName;
    }
}
