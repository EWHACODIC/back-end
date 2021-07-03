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
@Table(name="community_comment")
public class CommunityComment {
    @Id
    @GeneratedValue
    @Column(name = "id") // 댓글 번호
    private Long id;

    @Column(name = "content") // 댓글 내용
    private String content;

    @Column(name = "user_code")
    private Long userCode;

    @CreatedDate
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "modified_at")
    private LocalDateTime modifiedAt;


    @Column(name = "comment_id")
    private Long commentId;

    @Builder
    public CommunityComment(Long id, String content, Long userCode){
        this.id = id;
        this.content = content;
        this.userCode = userCode;
    }
}


