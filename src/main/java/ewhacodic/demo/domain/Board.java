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
    @Id
    @GeneratedValue
    @Column(name="id")
    private Long id;

    @Column(name="title")
    private String title;

    @Column(name="content")
    private String content;

    @Column(name="tag")
    private String tag;

    @Column(name="view")
    private int view;

    @Column(name="recommend")
    private int recommend;
  
    private String user_id;

    @CreatedDate
    @Column(name="created_at", updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name="modified_at")
    private LocalDateTime modifiedAt;

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


    public void updateView(){
        this.view++;
    }

    public void updateRecommend(){
        this.recommend++;
    }
}
