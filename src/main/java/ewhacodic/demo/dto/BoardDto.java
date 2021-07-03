package ewhacodic.demo.dto;

import ewhacodic.demo.domain.Board;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;
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
    private int recommend;
    private String user_id;
    private LocalDateTime createDate;
    private LocalDateTime modifiedDate;

    public Board toEntity(){
        Board build = Board.builder()
                .id(id)
                .title(title)
                .content(content)
                .tag(tag)
                .view(view)
                .recommend(recommend)
                .user_id(user_id)
                .build();
        return build;
    }

    @Builder
    public BoardDto(Long id, String title, String content, String tag, int view, int recommend, String user_id, LocalDateTime createDate, LocalDateTime modifiedDate){
        this.id = id;
        this.title = title;
        this.content = content;
        this.tag = tag;
        this.view = view;
        this.recommend = recommend;
        this.user_id = user_id;
        this.createDate = createDate;
        this.modifiedDate = modifiedDate;
    }

    public void updateView(){
        this.view++;
    }

    public void updateRecommend(){
        this.recommend++;
    }
}
