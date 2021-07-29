package ewhacodic.demo.dto;

import ewhacodic.demo.domain.Study;
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
    private String studyType;
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
    public StudyDto(Long id, Long maxPpl,  Long curPpl, Long time, Long password, String studyType,
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

}
