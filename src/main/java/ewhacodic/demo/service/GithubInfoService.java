package ewhacodic.demo.service;
import ewhacodic.demo.domain.GithubInfo;
import ewhacodic.demo.dto.CommitDto;
import ewhacodic.demo.dto.GithubInfoDto;

import ewhacodic.demo.repository.GithubInfoRepository;
import lombok.RequiredArgsConstructor;
import org.json.JSONArray;
//import org.json.simple.parser.JSONParser;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class GithubInfoService {

    private final GithubInfoRepository githubInfoRepository;

    public String save(GithubInfoDto infoDto) {
        return githubInfoRepository.save(GithubInfo.builder()
                .userName(infoDto.getUserName())
                .githubName(infoDto.getGithubName())
                .repoName(infoDto.getRepoName())
                .commits(infoDto.getCommits()).build()).getUserName();
    }

    public long CommitCount(GithubInfoDto githubInfoDto){ //커밋수 계산하는 함수-> 여기서 정의하고 Controller에서 호출해줄것
        long commits=0;
        String result="";

        try {
            URL url = new URL("https://api.github.com/repos/" + githubInfoDto.getGithubName()
                    + "/" + githubInfoDto.getRepoName() + "/stats/punch_card");
            BufferedReader bf;
            bf = new BufferedReader(new InputStreamReader(url.openStream())); //받아오기
            String line = "";

            while ((line = bf.readLine()) != null) { //하나의 문자열로 변환
                result = result.concat(line);
            }
            JSONArray jsonArray = new JSONArray(result);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONArray each = jsonArray.getJSONArray(i);
                commits += Integer.parseInt(String.valueOf(each.get(2))); // number형 Int로 바꾸는 방법-> String을 거친다
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return commits;
    }

    public List<CommitDto> getRankDtoList(){
        List<GithubInfo> commitList = githubInfoRepository.findAll();
        List<CommitDto> sortedRankDtoList = new ArrayList<>();
        AtomicReference<Long> rank = new AtomicReference<>(1L);
        List<GithubInfo> sortedCommitList = commitList
                .stream()
                .sorted(Comparator.comparing(GithubInfo::getCommits).reversed())
                .collect(Collectors.toList());

        sortedCommitList.forEach(it -> {
            sortedRankDtoList.add(CommitDto.of(it, rank.getAndSet(rank.get() + 1)));
        });

        return sortedRankDtoList;
    }
    public CommitDto getRankDto(String userName){
        List<CommitDto> commitDtoList = getRankDtoList();
        CommitDto commitDto = null;
        for(CommitDto c : commitDtoList){
            if(c.getUserName().equals(userName)){
                commitDto = c;
                break;
            }
        }
        return commitDto;
    }
}