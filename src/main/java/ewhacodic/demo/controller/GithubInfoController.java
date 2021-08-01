package ewhacodic.demo.controller;
import ewhacodic.demo.dto.CommitDto;
import ewhacodic.demo.dto.GithubInfoDto;
import ewhacodic.demo.service.GithubInfoService;
import ewhacodic.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class GithubInfoController {
    private final GithubInfoService githubInfoService;
    private final UserService userService;

    @RequestMapping(value = "/api/commit_count/{userName}", method = RequestMethod.GET)
    @ResponseBody
    public long commit_count_test(@PathVariable("userName") String userName) {
        GithubInfoDto githubInfoDto = new GithubInfoDto();
        githubInfoDto.setUserName(userName);
        githubInfoDto.setGithubName(userService.loadUserByUsername(userName).getGithubName());
        githubInfoDto.setRepoName(userService.loadUserByUsername(userName).getRepoName());

        long commits = githubInfoService.CommitCount(githubInfoDto);
        githubInfoDto.setCommits(commits); 
        githubInfoService.save(githubInfoDto);

        return commits;
    }

    @GetMapping("/api/rank")
    public List<CommitDto> getRankedCommitDto() {
        return githubInfoService.getRankDtoList();
    }
    
    @GetMapping("/api/rank/{userName}")
    public CommitDto getRank(@PathVariable("userName") String userName) {
        return githubInfoService.getRankDto(userName);
    }

}
