package ewhacodic.demo.service;

import ewhacodic.demo.domain.Study;
import ewhacodic.demo.dto.StudyDto;
import ewhacodic.demo.dto.StudyListDto;
import ewhacodic.demo.repository.StudyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@Service
@Transactional
public class StudyService {
    @Autowired
    private final StudyRepository studyRepository;

    public StudyService(StudyRepository studyRepository){
        this.studyRepository = studyRepository;
    }

    public List<StudyListDto> getStudyList(){
        return studyRepository.findAll().stream().map(StudyListDto::of).collect(toList());
    }

    public List<StudyListDto> getRecentStudyList(){
        return studyRepository.findAll()
                .stream()
                .sorted()
                .map(StudyListDto::of)
                .limit(8)
                .collect(Collectors.toList());
    }

    public StudyDto getStudyOnly(Long id){
        Optional<Study> studyWrapper = studyRepository.findById(id);

        return studyWrapper.map(StudyDto::of).orElseThrow(NoSuchElementException::new);
    }

    public void saveStudy(StudyDto studyDto){
        studyRepository.save(studyDto.toEntity().updateMember(studyDto.getUserCode(), studyDto.getPassword()));
    }

    public StudyDto joinStudy(Long studyId, Long userId, Long password){
        Optional<Study> study = studyRepository.findById(studyId);
        StudyDto studyDto = StudyDto.of(study.get().updateMember(userId, password));
        return studyDto;
    }

    public Long totalCount(){
        return studyRepository.findAll().stream().count();
    }
}
