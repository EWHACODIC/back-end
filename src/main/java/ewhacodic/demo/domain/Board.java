package ewhacodic.demo.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Setter
@Getter
@Entity
@Table(name="Post")
public class Board {
    @Id @GeneratedValue
    private Long id;
    private String title;
    private String content;
    private String tag;
    private int view;
    private int recommend;
    private String user_id;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime modifiedDate;

    @Builder
    public Board(Long id, String title, String content, String tag, int view, int recommend, String user_id){
        this.id = id;
        this.title = title;
        this.content = content;
        this.tag = tag;
        this.recommend = recommend;
        this.view = view;
        this.user_id = user_id;
    }
}
