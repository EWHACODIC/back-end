package ewhacodic.demo.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.gson.Gson;
import ewhacodic.demo.domain.Board;
import ewhacodic.demo.domain.Community;
import ewhacodic.demo.domain.Qna;
import ewhacodic.demo.domain.Tech;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@ToString
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@NoArgsConstructor
public class BoardListDto {
    private Long id;
    private String title;
    private List<String> tag;
    private Long view;
    private Long recommend;
    private Long commentCount;
    private Long userCode;
    private LocalDateTime createDate;
    private LocalDateTime modifiedDate;
    @JsonIgnore
    static Gson gsonObj = new Gson();

    @Builder
    public BoardListDto(Long id, String title, List<String> tag, Long view, Long recommend, Long commentCount, Long commentNum, Long userCode, LocalDateTime createDate, LocalDateTime modifiedDate) {
        this.id = id;
        this.title = title;
        this.tag = tag;
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
                .tag(gsonObj.fromJson(board.getTag(), List.class))
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
                .tag(gsonObj.fromJson(board.getTag(), List.class))
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
                .tag(gsonObj.fromJson(board.getTag(), List.class))
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
                .tag(gsonObj.fromJson(board.getTag(), List.class))
                .view(board.getView())
                .recommend(board.getRecommend())
                .commentCount(board.getCommentCount())
                .userCode(board.getUserCode())
                .createDate(board.getCreatedAt())
                .modifiedDate(board.getModifiedAt())
                .build();
    }
}