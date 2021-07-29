package ewhacodic.demo.dto;

import ewhacodic.demo.domain.UserInfo;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@ToString
public class UserLikePostDto {
    Set<Long> qnaLikeList;
    Set<Long> techLikeList;
    Set<Long> communityLikeList;

    @Builder
    public UserLikePostDto(Set<Long> qnaLikeList, Set<Long> techLikeList, Set<Long> communityLikeList) {
        this.qnaLikeList = qnaLikeList;
        this.techLikeList = techLikeList;
        this.communityLikeList = communityLikeList;
    }

    public static UserLikePostDto of(UserInfo userInfo) {
        return UserLikePostDto.builder()
                .qnaLikeList(userInfo.getQnaIds())
                .techLikeList(userInfo.getTechIds())
                .communityLikeList(userInfo.getCommunityIds())
                .build();
    }
}
