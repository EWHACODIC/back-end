package ewhacodic.demo.dto;

import ewhacodic.demo.domain.Board;
import ewhacodic.demo.domain.Community;
import ewhacodic.demo.domain.Qna;
import ewhacodic.demo.domain.Tech;
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
    private String tag1;
    private String tag2;
    private Long view;
    private Long recommend;
    private Long userCode;
    private LocalDateTime createDate;
    private LocalDateTime modifiedDate;

    public Board toEntity(){
        Board build = Board.builder()
                .id(id)
                .title(title)
                .content(content)
                .tag1(tag1)
                .tag2(tag2)
                .view(view)
                .recommend(recommend)
                .userCode(userCode)
                .createdAt(LocalDateTime.now())
                .modifiedAt(LocalDateTime.now())
                .build();
        return build;
    }

    public Qna toQna(){
        Qna build = Qna.builder()
                .id(id)
                .title(title)
                .content(content)
                .tag1(tag1)
                .tag2(tag2)
                .view(view)
                .recommend(recommend)
                .userCode(userCode)
                .createdAt(LocalDateTime.now())
                .modifiedAt(LocalDateTime.now())
                .build();
        return build;
    }

    public Community toCommunity(){
        Community build = Community.builder()
                .id(id)
                .title(title)
                .content(content)
                .tag1(tag1)
                .tag2(tag2)
                .view(view)
                .recommend(recommend)
                .userCode(userCode)
                .createdAt(LocalDateTime.now())
                .modifiedAt(LocalDateTime.now())
                .build();
        return build;
    }

    public Tech toTech(){
        Tech build = Tech.builder()
                .id(id)
                .title(title)
                .content(content)
                .tag1(tag1)
                .tag2(tag2)
                .view(view)
                .recommend(recommend)
                .userCode(userCode)
                .createdAt(LocalDateTime.now())
                .modifiedAt(LocalDateTime.now())
                .build();
        return build;
    }

    @Builder
    public BoardDto(Long id, String title, String content, String tag1, String tag2, Long view, Long recommend, Long userCode, LocalDateTime createDate, LocalDateTime modifiedDate){
        this.id = id;
        this.title = title;
        this.content = content;
        this.tag1 = tag1;
        this.tag2 = tag2;
        this.view = view;
        this.recommend = recommend;
        this.userCode = userCode;
        this.createDate = createDate;
        this.modifiedDate = modifiedDate;
    }

}
