package ewhacodic.demo.dto;

import ewhacodic.demo.domain.Study;
import ewhacodic.demo.enums.StudyType;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
public class StudyListDto {
    private Long id;
    private String title;
    private Long maxPpl;
    private Long curPpl;
    private Long time;
    private Long password;
    private String day1;
    private String day2;
    private LocalTime startTime;
    private LocalTime endTime;
    private StudyType studyType;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private LocalDate startAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private LocalDate endAt;
    private LocalDateTime createdAt;
    private String userCode;
    private Set<String> userList;
    private String description;

    public static StudyListDto of(Study study){
        return StudyListDto.builder()
                .id(study.getId())
                .title(study.getTitle())
                .maxPpl(study.getMaxPpl())
                .curPpl(study.getCurPpl())
                .time(study.getTime())
                .day1(study.getDay1())
                .day2(study.getDay2())
                .startTime(study.getStartTime())
                .endTime(study.getEndTime())
                .password(study.getPassword())
                .studyType((study.getStudyType()))
                .startAt(study.getStartAt())
                .endAt(study.getEndAt())
                .createdAt(study.getCreatedAt())
                .userCode(study.getUserCode())
                .userList(study.getUserList())
                .description(study.getDescription())
                .build();
    }
}
