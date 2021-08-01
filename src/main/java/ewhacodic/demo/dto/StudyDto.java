package ewhacodic.demo.dto;

import ewhacodic.demo.domain.Study;
import ewhacodic.demo.enums.StudyType;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class StudyDto {
    private Long id;
    private String title;
    private Long maxPpl;
    private Long curPpl;
    private Long time;
    private Long password;
    private StudyType studyType;
    private String day1;
    private String day2;
    private LocalTime startTime;
    private LocalTime endTime;
    private LocalDate startAt;
    private LocalDate endAt;
    private LocalDateTime createdAt;
    private String userCode;
    private Set<String> userList = new HashSet<>();
    private String description;

    public Study toEntity(){
        Study build = Study.builder()
                .id(id)
                .title(title)
                .curPpl(curPpl)
                .maxPpl(maxPpl)
                .time(time)
                .day1(day1)
                .day2(day2)
                .startTime(startTime)
                .endTime(endTime)
                .studyType(studyType)
                .password(password)
                .startAt(startAt)
                .endAt(endAt)
                .createdAt(LocalDateTime.now())
                .userCode(userCode)
                .userList(userList)
                .description(description)
                .build();
        return build;
    }

    @Builder
    public StudyDto(Long id, String title, Long maxPpl,  Long curPpl, Long time, Long password,
                    String day1, String day2, LocalTime startTime, LocalTime endTime, StudyType studyType,
                    LocalDate startAt, LocalDate endAt, LocalDateTime createdAt, String userCode,
                    Set<String> userList, String description){
        this.id = id;
        this.title = title;
        this.maxPpl = maxPpl;
        this.curPpl = curPpl;
        this.time = time;
        this.day1 = day1;
        this.day2 = day2;
        this.startTime = startTime;
        this.endTime = endTime;
        this.password = password;
        this.studyType = studyType;
        this.startAt = startAt;
        this.endAt = endAt;
        this.createdAt = createdAt;
        this.userCode = userCode;
        this.userList = userList;
        this.description = description;
    }

    public static StudyDto of(Study study) {
        return StudyDto.builder()
                .id(study.getId())
                .title(study.getTitle())
                .maxPpl(study.getMaxPpl())
                .curPpl(study.getCurPpl())
                .time(study.getTime())
                .password(study.getPassword())
                .day1(study.getDay1())
                .day2(study.getDay2())
                .startTime(study.getStartTime())
                .endTime(study.getEndTime())
                .studyType(study.getStudyType())
                .startAt(study.getStartAt())
                .endAt(study.getEndAt())
                .createdAt(study.getCreatedAt())
                .userCode(study.getUserCode())
                .userList(study.getUserList())
                .description(study.getDescription())
                .build();
    }

}
