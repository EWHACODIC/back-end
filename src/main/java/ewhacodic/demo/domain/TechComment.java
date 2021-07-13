package ewhacodic.demo.domain;

import ewhacodic.demo.dto.BoardCommentDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Setter
@Getter
@Entity
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Table(name="tech_comment")
public class TechComment {
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

    @Column(name = "post_id")
    private Long postId;

    @Builder
    public TechComment(Long id, String content, Long userCode, Long postId, LocalDateTime createdAt, LocalDateTime modifiedAt){
        this.id = id;
        this.content = content;
        this.userCode = userCode;
        this.postId = postId;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }

    public static TechComment of(BoardCommentDto boardCommentDto, Long postId) {
        return TechComment.builder()
                .content(boardCommentDto.getContent())
                .userCode(boardCommentDto.getUserCode())
                .postId(postId)
                .createdAt(LocalDateTime.now())
                .modifiedAt(LocalDateTime.now())
                .build();
    }
}


