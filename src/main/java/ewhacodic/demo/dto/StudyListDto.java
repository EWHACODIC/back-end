package ewhacodic.demo.dto;

import ewhacodic.demo.domain.Study;
import ewhacodic.demo.enums.StudyType;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
public class StudyListDto {
    private Long id;
    private Long maxPpl;
    private Long curPpl;
    private Long time;
    private Long password;
    private StudyType studyType;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private LocalDate startAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private LocalDate endAt;
    private LocalDateTime createdAt;
    private Long userCode;
    private String description;

    public static StudyListDto of(Study study){
        return StudyListDto.builder()
                .id(study.getId())
                .maxPpl(study.getMaxPpl())
                .curPpl(study.getCurPpl())
                .time(study.getTime())
                .password(study.getPassword())
                .startAt(study.getStartAt())
                .endAt(study.getEndAt())
                .createdAt(study.getCreatedAt())
                .userCode(study.getUserCode())
                .description(study.getDescription())
                .build();
    }
}
