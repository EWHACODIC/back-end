package ewhacodic.demo.controller;

import ewhacodic.demo.payload.DefaultResponse;
import ewhacodic.demo.payload.ResponseCode;
import ewhacodic.demo.payload.response.OneUserRankResponse;
import ewhacodic.demo.payload.response.UserRankInfoResponse;
import ewhacodic.demo.security.CurrentUser;
import ewhacodic.demo.security.GoogleUserPrincipal;
import ewhacodic.demo.service.UserRankService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.jyami.commitersewha.payload.ResponseMessage.*;

@RequestMapping("api/rank")
@RestController
@RequiredArgsConstructor
@Slf4j
public class UserRankController {

    private final UserRankService userRankService;

    @PostMapping
    public ResponseEntity<?> saveRank(@CurrentUser GoogleUserPrincipal googleUserPrincipal) {
        log.info("---saveRankAsQuarter : parameter = {}", googleUserPrincipal.getId());
        userRankService.saveRank(googleUserPrincipal.getId());
        return ResponseEntity.ok()
                .body(DefaultResponse.of(ResponseCode.OK, UPDATE_COMMIT_RANK_SUCCESS));
    }

    @GetMapping("me")
    public ResponseEntity<?> getMyRankDetailAsQuarterAndWeek(@CurrentUser GoogleUserPrincipal googleUserPrincipal) {
        log.info("---getMyRank : parameter = {}", googleUserPrincipal.getId());
        OneUserRankResponse userRanks = userRankService.getMyRankScore(googleUserPrincipal.getId());
        return ResponseEntity.ok()
                .body(DefaultResponse.of(ResponseCode.OK, FIND_RANKING_INFO_SUCCESS, userRanks));
    }

    @GetMapping("{subId}")
    public ResponseEntity<?> getRankDetailAsQuarterAndWeek(@CurrentUser GoogleUserPrincipal googleUserPrincipal,
                                                           @PathVariable String subId) {
        log.info("---getRank : parameter = {} => {}", googleUserPrincipal.getId(), subId);
        OneUserRankResponse userRanks = userRankService.getSingleUserRankScore(subId);
        return ResponseEntity.ok()
                .body(DefaultResponse.of(ResponseCode.OK, FIND_RANKING_INFO_SUCCESS, userRanks));
    }

    @GetMapping("quarter")
    public ResponseEntity<?> getQuarterRanking(@CurrentUser GoogleUserPrincipal googleUserPrincipal) {
        log.info("---getQuarterRank : parameter = {}", googleUserPrincipal.getId());
        List<UserRankInfoResponse> rankingQuarter = userRankService.getRankingQuarter();
        return ResponseEntity.ok()
                .body(DefaultResponse.of(ResponseCode.OK, FIND_RANKING_QUARTER_SUCCESS, rankingQuarter));
    }

    @GetMapping("week")
    public ResponseEntity<?> getWeekRanking(@CurrentUser GoogleUserPrincipal googleUserPrincipal) {
        log.info("---getWeekrRank : parameter = {}", googleUserPrincipal.getId());
        List<UserRankInfoResponse> rankingWeek = userRankService.getRankingWeek();
        return ResponseEntity.ok()
                .body(DefaultResponse.of(ResponseCode.OK, FIND_RANKING_WEEK_SUCCESS, rankingWeek));
    }
}
