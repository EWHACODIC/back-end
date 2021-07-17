package ewhacodic.demo.domain;

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
@Table(name="qna")
public class Qna{
    @Id
    @GeneratedValue
    @Column(name="id") // 게시글 번호
    private Long id;

    @Column(name="title") // 게시글 제목
    private String title;

    @Column(name="content") // 게시글 내용
    private String content;

    @Column(name="tag1")
    private String tag1;

    @Column(name="tag2")
    private String tag2;

    @Column(name="view") // 조회수
    private Long view;

    @Column(name="recommend") // 추천수
    private Long recommend;

    @Column(name="user_code") // 작성자 아이디
    private Long userCode;

    @OneToMany(fetch=FetchType.EAGER)
    @JoinColumn(name="comment_id")
    private List<TechComment> comments;

    @CreatedDate
    @Column(name="created_at", updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name="modified_at")
    private LocalDateTime modifiedAt;

    @Builder
    public Qna(Long id, String title, String content, String tag1, String tag2, Long view, Long recommend, Long userCode, LocalDateTime createdAt, LocalDateTime modifiedAt){
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

    public static Qna updateRecommend(Qna boardDto) {
        Long recommend = boardDto.getRecommend() + 1;
        Qna qna = boardDto;
        qna.setRecommend(recommend);

        return qna;
    }
}

