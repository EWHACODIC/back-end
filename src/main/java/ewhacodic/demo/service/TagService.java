package ewhacodic.demo.service;

import ewhacodic.demo.dto.TagDto;
import ewhacodic.demo.repository.TagRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}
