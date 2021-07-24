package ewhacodic.demo.controller;

import ewhacodic.demo.dto.TagDto;
import ewhacodic.demo.service.TagService;
import ewhacodic.demo.service.UserService;
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
    @Autowired
    private TagService tagService;
    private UserService userService;

    public TagController(TagService tagService, UserService userService) {
        this.tagService = tagService;
        this.userService = userService;
    }

    public TagController(TagService tagService){
        this.tagService = tagService;
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
}
