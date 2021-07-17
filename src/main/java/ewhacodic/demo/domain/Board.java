package ewhacodic.demo.domain;

import ewhacodic.demo.dto.BoardDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@Entity
@NoArgsConstructor
@Table(name="Board")
public class Board {
    @Id
    @GeneratedValue
    @Column(name="id")
    private Long id;

    @Column(name="title")
    private String title;

    @Column(name="content")
    private String content;

    @Column(name="tag1")
    private String tag1;

    @Column(name="tag2")
    private String tag2;

    @Column(name="view")
    private Long view;

    @Column(name="recommend")
    private Long recommend;

    @OneToMany(fetch=FetchType.EAGER)
    @JoinColumn(name="post_id")
    private List<BoardComment> comments;

    @Column(name="user_code")
    private Long userCode;

    @CreatedDate
    @Column(name="created_at", updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name="modified_at")
    private LocalDateTime modifiedAt;

    @Builder
    public Board(Long id, String title, String content, String tag1, String tag2, Long view, Long recommend, Long userCode, LocalDateTime createdAt, LocalDateTime modifiedAt){
        this.id = id;
        this.title = title;
        this.content = content;
        this.tag1 = tag1;
        this.tag2 = tag2;
        this.recommend = recommend;
        this.view = view;
        this.userCode = userCode;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }


    public void updateView(){
        this.view++;
    }

    public static Board updateRecommend(Board boardDto) {
        Long recommend = boardDto.getRecommend() + 1;
        Board board = boardDto;
        board.setRecommend(recommend);

        return board;
    }
}
