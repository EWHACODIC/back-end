package ewhacodic.demo.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name="community")
public class Community {
    @Id
    @GeneratedValue
    @Column(name="id") // 게시글 번호
    private Long id;

    @Column(name="title") // 게시글 제목
    private String title;

    @Column(name="content") // 게시글 내용
    private String content;

    @Column(name="tag") // 태그
    private String tag;

    @Column(name="view") // 조회수
    private Long view;

    @Column(name="recommend") // 추천수
    private Long recommend;

    @Column(name="user_code") // 작성자 아이디
    private Long userCode;

    @OneToMany(fetch=FetchType.EAGER)
    @JoinColumn(name="comment_id")
    private List<CommunityComment> comments;

    @CreatedDate
    @Column(name="created_at", updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name="modified_at")
    private LocalDateTime modifiedAt;

    @Builder
    public Community(Long id, String title, String content, String tag, Long view, Long recommend, Long userCode){
        this.id = id;
        this.title = title;
        this.content = content;
        this.tag = tag;
        this.view = view;
        this.recommend = recommend;
        this.userCode = userCode;
    }
}
