/*package ewhacodic.demo.domain;

import ewhacodic.demo.dto.BoardCommentDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Setter
@Getter
@Entity
@NoArgsConstructor
@Table(name="board_comment")
public class BoardComment {
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


    @Column(name = "post_id")
    private Long postId;

    @Builder
    public BoardComment(Long id, String content, Long userCode, Long postId){
        this.id = id;
        this.content = content;
        this.userCode = userCode;
        this.postId = postId;
    }

    public static BoardComment of(BoardCommentDto boardCommentDto, Long postId) {
        return BoardComment.builder()
                .content(boardCommentDto.getContent())
                .userCode(boardCommentDto.getUserCode())
                .postId(postId)
                .build();
    }
}*/