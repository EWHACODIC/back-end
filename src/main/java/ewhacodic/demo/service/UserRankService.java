package ewhacodic.demo.domain.service;

import ewhacodic.demo.domain.githubInfo.GithubInfo;
import ewhacodic.demo.domain.githubInfo.GithubInfoRepository;
import ewhacodic.demo.domain.userRank.UserRank;
import ewhacodic.demo.domain.userRank.UserRankRepository;
//import ewhacodic.demo.exception.ResourceNotFoundException;
import ewhacodic.demo.payload.response.OneUserRankResponse;
import ewhacodic.demo.payload.response.UserRankInfoResponse;
import ewhacodic.demo.util.TimeUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserRankService {

    private final UserRankRepository userRankRepository;
    private final GithubInfoRepository githubInfoRepository;
    private final CommitInfoRepository commitInfoRepository;

    @Transactional
    public void saveRank(Long userId) {
        GithubInfo githubInfo = githubInfoRepository.findByUserId(userId)
        //        .orElseThrow(() -> new ResourceNotFoundException("GithubInfo", "userId", userId));
        saveRankAsQuarter(githubInfo);
        saveRankAsWeek(githubInfo);
    }

    public OneUserRankResponse getMyRankScore(Long userId) {
        GithubInfo githubInfo = githubInfoRepository.findByUserId(userId)
        //        .orElseThrow(() -> new ResourceNotFoundException("GithubInfo", "userId", userId));
        UserRank quarterRankScore = findQuarterRankScore(githubInfo);
        UserRank weekRankScore = findWeekRankScore(githubInfo);
        return new OneUserRankResponse(UserRankInfoResponse.of(weekRankScore, githubInfo), UserRankInfoResponse.of(quarterRankScore, githubInfo));
    }

    public OneUserRankResponse getSingleUserRankScore(String subId) {
        GithubInfo githubInfo = githubInfoRepository.findByUserSubId(subId)
        //        .orElseThrow(() -> new ResourceNotFoundException("GithubInfo", "subId", subId));
        UserRank quarterRankScore = findQuarterRankScore(githubInfo);
        UserRank weekRankScore = findWeekRankScore(githubInfo);
        return new OneUserRankResponse(UserRankInfoResponse.of(weekRankScore, githubInfo), UserRankInfoResponse.of(quarterRankScore, githubInfo));
    }

    private UserRank findWeekRankScore(GithubInfo githubInfo){
        LocalDateTime thisWeekStartTime = TimeUtils.getThisWeekStartTime(LocalDate.now());
        return userRankRepository.findByGithubInfoAndWeekAndLocalDate(githubInfo, true, thisWeekStartTime.toLocalDate())
                .orElseGet(() -> UserRank.emptyUserRank(githubInfo));
    }

    private UserRank findQuarterRankScore(GithubInfo githubInfo){
        LocalDateTime thisQuarterStartTime = TimeUtils.getThisQuarterStartTime(LocalDate.now());
        return userRankRepository.findByGithubInfoAndWeekAndLocalDate(githubInfo, false, thisQuarterStartTime.toLocalDate())
                .orElseGet(() -> UserRank.emptyUserRank(githubInfo));
    }

    public List<UserRankInfoResponse> getRankingWeek() {
        LocalDateTime thisWeekStartTime = TimeUtils.getThisWeekStartTime(LocalDate.now());
        return userRankRepository.findAllUserRankings(true, thisWeekStartTime.toLocalDate())
                .stream()
                .map(x -> UserRankInfoResponse.of(x, x.getGithubInfo()))
                .collect(Collectors.toList());
    }

    public List<UserRankInfoResponse> getRankingQuarter() {
        LocalDateTime thisQuarterStartTime = TimeUtils.getThisQuarterStartTime(LocalDate.now());
        return userRankRepository.findAllUserRankings(false, thisQuarterStartTime.toLocalDate())
                .stream()
                .map(x -> UserRankInfoResponse.of(x, x.getGithubInfo()))
                .collect(Collectors.toList());
    }

    private void saveRankAsWeek(GithubInfo githubInfo) {
        UserRank weekRankScore = findWeekRankScore(githubInfo);
        LocalDateTime thisWeekStartTime = TimeUtils.getThisWeekStartTime(LocalDate.now());
        List<CommitMap> commitWeek = findCommitMapStartTime(githubInfo.getInfoId(), thisWeekStartTime);
        UserRank userRank = CommitMapRank.calculate(commitWeek).of(thisWeekStartTime.toLocalDate(), true, githubInfo);
        weekRankScore.updateUserRank(userRank);
        userRankRepository.save(weekRankScore);
    }

    private void saveRankAsQuarter(GithubInfo githubInfo) {
        UserRank quarterRankScore = findQuarterRankScore(githubInfo);
        LocalDateTime thisQuarterStartTime = TimeUtils.getThisQuarterStartTime(LocalDate.now());
        List<CommitMap> commitQuarter = findCommitMapStartTime(githubInfo.getInfoId(), thisQuarterStartTime);
        UserRank userRank = CommitMapRank.calculate(commitQuarter).of(thisQuarterStartTime.toLocalDate(), false, githubInfo);
        quarterRankScore.updateUserRank(userRank);
        userRankRepository.save(quarterRankScore);
    }

    private List<CommitMap> findCommitMapStartTime(Long githubInfoId, LocalDateTime startTime) {
        return commitInfoRepository.findCommitMapCount(startTime, TimeUtils.getTodayEndTime(), githubInfoId);
    }

}
