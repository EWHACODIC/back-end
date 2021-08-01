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

    @Column(name="tag")
    private String tag;

    @Column(name="view") // 조회수
    private Long view;

    @Column(name="recommend") // 추천수
    private Long recommend;

    @Column(name="comment_count")
    private Long commentCount;

    @Column(name="user_code") // 작성자 아이디
    private Long userCode;

    @OneToMany(fetch=FetchType.EAGER)
    @JoinColumn(name="post_id")
    private List<CommunityComment> comments;

    @CreatedDate
    @Column(name="created_at", updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name="modified_at")
    private LocalDateTime modifiedAt;

    @Builder
    public Community(Long id, String title, String content, String tag, Long view, Long recommend, Long commentCount,Long userCode, LocalDateTime createdAt, LocalDateTime modifiedAt){
        this.id = id;
        this.title = title;
        this.content = content;
        this.tag = tag;
        this.recommend = recommend;
        this.commentCount = commentCount;
        this.view = view;
        this.userCode = userCode;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }

    public void updateView(){
        this.view++;
    }

    public static Community updateRecommend(Community boardDto) {
        Long recommend = boardDto.getRecommend() + 1;
        Community community = boardDto;
        community.setRecommend(recommend);

        return community;
    }

    public Community renewCommentCount(){
        this.setCommentCount(this.getComments().stream().count());
        return this;
    }
}
