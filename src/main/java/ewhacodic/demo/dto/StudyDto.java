package ewhacodic.demo.dto;

import ewhacodic.demo.domain.Study;
import ewhacodic.demo.enums.StudyType;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class StudyDto {
    private Long id;
    private Long maxPpl;
    private Long curPpl;
    private Long time;
    private Long password;
    private StudyType studyType;
    private LocalDate startAt;
    private LocalDate endAt;
    private LocalDateTime createdAt;
    private Long userCode;
    private String description;

    public Study toEntity(){
        Study build = Study.builder().
                id(id)
                .curPpl(curPpl)
                .maxPpl(maxPpl)
                .time(time)
                .studyType(studyType)
                .password(password)
                .startAt(startAt)
                .endAt(endAt)
                .createdAt(LocalDateTime.now())
                .userCode(userCode)
                .description(description)
                .build();
        return build;
    }

    @Builder
    public StudyDto(Long id, Long maxPpl,  Long curPpl, Long time, Long password, StudyType studyType,
                 LocalDate startAt, LocalDate endAt, LocalDateTime createdAt,
                 Long userCode, String description){
        this.id = id;
        this.maxPpl = maxPpl;
        this.curPpl = curPpl;
        this.time = time;
        this.password = password;
        this.studyType = studyType;
        this.startAt = startAt;
        this.endAt = endAt;
        this.createdAt = createdAt;
        this.userCode = userCode;
        this.description = description;
    }

    public static StudyDto of(Study study) {
        return StudyDto.builder()
                .id(study.getId())
                .maxPpl(study.getMaxPpl())
                .curPpl(study.getCurPpl())
                .time(study.getTime())
                .password(study.getPassword())
                .studyType(study.getStudyType())
                .startAt(study.getStartAt())
                .endAt(study.getEndAt())
                .createdAt(study.getCreatedAt())
                .userCode(study.getUserCode())
                .description(study.getDescription())
                .build();
    }

}
