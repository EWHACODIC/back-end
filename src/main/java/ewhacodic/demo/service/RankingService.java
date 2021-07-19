package ewhacodic.demo.service;

import ewhacodic.demo.rankMember.Member;
import ewhacodic.demo.ranking.RankingType;

import java.util.List;

public interface RankingService {
    String RANKING_GETTING_KEY = "ranking:get";

    List<Member> getRanking(RankingType type);
}
