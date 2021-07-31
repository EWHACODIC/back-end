package ewhacodic.demo.controller;
import ewhacodic.demo.dto.GithubInfoDto;
import ewhacodic.demo.dto.UserInfoDto;
import ewhacodic.demo.repository.UserRepository;
import ewhacodic.demo.service.GithubInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RequiredArgsConstructor
@Controller
public class GithubInfoController {
    private final GithubInfoService githubInfoService;

    @Autowired
    private UserRepository userRepository; //주입

    //테스트용
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/api/commit_count_test")
    @ResponseBody
    public long commit_count_test(GithubInfoDto githubInfoDto) {

        //임의로 상황 설정해줌
        githubInfoDto.setUserName("ottl-seo");
        githubInfoDto.setRepoName("Algorithm");
        githubInfoDto.setStartDate("2021-07-01T00:00:00Z");
        //CurrentDate는 자동 생성
        githubInfoDto.setCurrentDate("2021-07-20T00:00:00Z");

        long commits = githubInfoService.CommitCount(githubInfoDto);
        return commits;
    }
/*
    @RequestMapping(value = "/api/commit_count/{userName}") //, method = RequestMethod.GET 삭제
    @ResponseBody
    public long commit_count_test(@PathVariable("userName") String userName) throws Exception {
        UserInfoDto userInfoDto = userRepository.findByUserName(userName); //여기 오류
        GithubInfoDto githubInfoDto = new GithubInfoDto(); //서비스에 주입해줄 dto 생성

        githubInfoDto.setUserName(userInfoDto.getGithubName());
        githubInfoDto.setRepoName(userInfoDto.getRepoName());
        githubInfoDto.setStartDate("2021-07-01T00:00:00Z");
        //CurrentDate는 자동 생성
        githubInfoDto.setCurrentDate("2021-07-20T00:00:00Z");

        long commits = githubInfoService.CommitCount(githubInfoDto);
        return commits;
    }
 */

}
