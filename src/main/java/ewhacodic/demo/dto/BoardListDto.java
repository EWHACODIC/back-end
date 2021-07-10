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
    private String tag;
    private Long view;
    private Long recommend;
    private Long commentNum;
    private Long userCode;
    private LocalDateTime createDate;
    private LocalDateTime modifiedDate;

    @Builder
    public BoardListDto(Long id, String title,String tag, Long view, Long recommend, Long commentNum, Long userCode, LocalDateTime createDate, LocalDateTime modifiedDate) {
        this.id = id;
        this.title = title;
        this.tag = tag;
        this.view = view;
        this.recommend = recommend;
        this.commentNum = commentNum;
        this.userCode = userCode;
        this.createDate = createDate;
        this.modifiedDate = modifiedDate;
    }

    public static BoardListDto of(Board board) {
        return BoardListDto.builder()
                .id(board.getId())
                .title(board.getTitle())
                .tag(board.getTag())
                .view(board.getView())
                .recommend(board.getRecommend())
                .commentNum(board.getComments().stream().count())
                .userCode(board.getUserCode())
                .createDate(board.getCreatedAt())
                .modifiedDate(board.getModifiedAt())
                .build();
    }

    public static BoardListDto ofQna (Qna board) {
        return BoardListDto.builder()
                .id(board.getId())
                .title(board.getTitle())
                .tag(board.getTag())
                .view(board.getView())
                .recommend(board.getRecommend())
                .commentNum(board.getComments().stream().count())
                .userCode(board.getUserCode())
                .createDate(board.getCreatedAt())
                .modifiedDate(board.getModifiedAt())
                .build();
    }

    public static BoardListDto ofTech(Tech board) {
        return BoardListDto.builder()
                .id(board.getId())
                .title(board.getTitle())
                .tag(board.getTag())
                .view(board.getView())
                .recommend(board.getRecommend())
                .commentNum(board.getComments().stream().count())
                .userCode(board.getUserCode())
                .createDate(board.getCreatedAt())
                .modifiedDate(board.getModifiedAt())
                .build();
    }

    public static BoardListDto ofCommunity (Community board) {
        return BoardListDto.builder()
                .id(board.getId())
                .title(board.getTitle())
                .tag(board.getTag())
                .view(board.getView())
                .recommend(board.getRecommend())
                .commentNum(board.getComments().stream().count())
                .userCode(board.getUserCode())
                .createDate(board.getCreatedAt())
                .modifiedDate(board.getModifiedAt())
                .build();
    }
}