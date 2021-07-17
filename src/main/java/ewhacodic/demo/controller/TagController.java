package ewhacodic.demo.controller;

import ewhacodic.demo.dto.TagDto;
import ewhacodic.demo.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tag")
public class TagController {
    @Autowired
    private TagService tagService;

    public TagController(TagService tagService){
        this.tagService = tagService;
    }

    //전체 태그 불러오기
    @GetMapping("/list")
    public List<TagDto> allTagList(){
        return tagService.getTagList();
    }
}
