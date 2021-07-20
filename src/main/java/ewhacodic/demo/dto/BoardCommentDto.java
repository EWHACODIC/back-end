package ewhacodic.demo.dto;

import ewhacodic.demo.domain.Board;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class BoardCommentDto {
    private String content;
    private Long userCode;
}
