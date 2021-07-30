package ewhacodic.demo.controller;

import ewhacodic.demo.dto.TagDto;
import ewhacodic.demo.dto.UserLikePostDto;
import ewhacodic.demo.service.TagService;
import ewhacodic.demo.service.UserService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.UserCredentialsDataSourceAdapter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/tag")
public class TagController {
    private final TagService tagService;
    private final UserService userService;

    public TagController(TagService tagService, UserService userService) {
        this.tagService = tagService;
        this.userService = userService;
    }

    //전체 태그 불러오기
    @GetMapping("/list")
    public List<TagDto> allTagList(){
        return tagService.getTagList();
    }

    @GetMapping("/{userCode}")
    public Set<Long> getUserTag(@PathVariable Long userCode) {
        return userService.getUserTagIds(userCode);
    }

    @GetMapping("/dto/{userCode}")
    public Set<TagDto> getTagDto(@PathVariable Long userCode) {
        return userService.getUserTagDtos(userCode);
    }

    //UserController template error 문제로 임시로 여기에 위치시켰습니다.
    @GetMapping("/user/post/{userCode}")
    public UserLikePostDto getUserLikeList(@PathVariable Long userCode) {
        return userService.getUserLiktPostList(userCode);
    }
}
