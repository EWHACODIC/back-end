package ewhacodic.demo.payload.response;

import lombok.*;


@NoArgsConstructor
@Getter
@AllArgsConstructor
public class OneUserRankResponse {
    private UserRankInfoResponse weekRank;
    private UserRankInfoResponse quarterRank;
}
