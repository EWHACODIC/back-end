package ewhacodic.demo.dto;

import ewhacodic.demo.domain.Board;
import ewhacodic.demo.domain.Community;
import ewhacodic.demo.domain.Qna;
import ewhacodic.demo.domain.Tech;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class BoardListDto {
    private Long id;
    private String title;
    private String tag1;
    private String tag2;
    private Long view;
    private Long recommend;
    private Long commentCount;
    private Long userCode;
    private LocalDateTime createDate;
    private LocalDateTime modifiedDate;

    @Builder
    public BoardListDto(Long id, String title,String tag1, String tag2, Long view, Long recommend, Long commentCount, Long commentNum, Long userCode, LocalDateTime createDate, LocalDateTime modifiedDate) {
        this.id = id;
        this.title = title;
        this.tag1 = tag1;
        this.tag2 = tag2;
        this.view = view;
        this.recommend = recommend;
        this.commentCount = commentCount;
        this.userCode = userCode;
        this.createDate = createDate;
        this.modifiedDate = modifiedDate;
    }

    public static BoardListDto of(Board board) {
        return BoardListDto.builder()
                .id(board.getId())
                .title(board.getTitle())
                .tag1(board.getTag1())
                .tag2(board.getTag2())
                .view(board.getView())
                .recommend(board.getRecommend())
                .commentCount(board.getCommentCount())
                .userCode(board.getUserCode())
                .createDate(board.getCreatedAt())
                .modifiedDate(board.getModifiedAt())
                .build();
    }

    public static BoardListDto ofQna (Qna board) {
        return BoardListDto.builder()
                .id(board.getId())
                .title(board.getTitle())
                .tag1(board.getTag1())
                .tag2(board.getTag2())
                .view(board.getView())
                .recommend(board.getRecommend())
                .commentCount(board.getCommentCount())
                .userCode(board.getUserCode())
                .createDate(board.getCreatedAt())
                .modifiedDate(board.getModifiedAt())
                .build();
    }

    public static BoardListDto ofTech(Tech board) {
        return BoardListDto.builder()
                .id(board.getId())
                .title(board.getTitle())
                .tag1(board.getTag1())
                .tag2(board.getTag2())
                .view(board.getView())
                .recommend(board.getRecommend())
                .commentCount(board.getCommentCount())
                .userCode(board.getUserCode())
                .createDate(board.getCreatedAt())
                .modifiedDate(board.getModifiedAt())
                .build();
    }

    public static BoardListDto ofCommunity (Community board) {
        return BoardListDto.builder()
                .id(board.getId())
                .title(board.getTitle())
                .tag1(board.getTag1())
                .tag2(board.getTag2())
                .view(board.getView())
                .recommend(board.getRecommend())
                .commentCount(board.getCommentCount())
                .userCode(board.getUserCode())
                .createDate(board.getCreatedAt())
                .modifiedDate(board.getModifiedAt())
                .build();
    }
}