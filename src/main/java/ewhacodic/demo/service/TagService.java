package ewhacodic.demo.service;

import ewhacodic.demo.domain.Tag;
import ewhacodic.demo.dto.TagDto;
import ewhacodic.demo.repository.TagRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class TagService {

    private final TagRepository tagRepository;

    public TagService(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    public TagDto of(Long tagId) {
        return TagDto.builder()
                .tagId(tagId)
                .tagName(tagRepository.findOneById(tagId).getTagName())
                .build();
    }

    public List<TagDto> getTagList(){
        List<Tag> tagList = tagRepository.findAll();
        List<TagDto> tagDtoList = new ArrayList<>();
        for(Tag tag:tagList){
            TagDto tagDto = TagDto.builder()
                    .tagId(tag.getId())
                    .tagName(tag.getTagName())
                    .build();

            tagDtoList.add(tagDto);
        }
        return tagDtoList;
    }
}
