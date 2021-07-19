package ewhacodic.demo.service;

import ewhacodic.demo.config.Cacheable;
import ewhacodic.demo.rankMember.Member;
import ewhacodic.demo.ranking.RankingType;
import ewhacodic.demo.rankMember.MemberRepository;
import ewhacodic.demo.service.RankingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AopRankingService implements RankingService {
    private final Logger log = LoggerFactory.getLogger(getClass());
    private final MemberRepository memberRepository;

    public AopRankingService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    @Cacheable(RANKING_GETTING_KEY)
    public List<Member> getRanking(RankingType type) {
        log.info("business logic execution");
        return this.memberRepository.findAll()
                .stream()
//              .sorted() 랭킹을 정하는 로직이 있다고 가정
                .collect(Collectors.toList());
    }
}
