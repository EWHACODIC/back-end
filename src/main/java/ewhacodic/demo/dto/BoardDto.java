package ewhacodic.demo.dto;

import ewhacodic.demo.domain.Board;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class BoardDto {
    private Long id;
    private String title;
    private String content;
    private String tag;
    private int view;
    private String userId;
    private LocalDateTime createDate;
    private LocalDateTime modifiedDate;

    public Board toEntity(){
        Board build = Board.builder()
                .id(id)
                .title(title)
                .content(content)
                .tag(tag)
                .view(view)
                .userId(userId)
                .build();
        return build;
    }

    @Builder
    public BoardDto(Long id, String title, String content, String tag, int view, String userId, LocalDateTime createDate, LocalDateTime modifiedDate){
        this.id = id;
        this.title = title;
        this.content = content;
        this.tag = tag;
        this.view = view;
        this.userId = userId;
        this.createDate = createDate;
        this.modifiedDate = modifiedDate;
    }
}
