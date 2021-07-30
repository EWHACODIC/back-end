package ewhacodic.demo.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import ewhacodic.demo.dto.StudyListDto;
import ewhacodic.demo.enums.StudyType;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Setter
@Getter
@Entity
@NoArgsConstructor
@Table(name="study")
public class Study implements Comparable<Study> {
    @Id
    @GeneratedValue
    @Column(name="id")
    private Long id;

    @Column(name="max_ppl")
    private Long maxPpl;

    @Column(name="cur_ppl")
    private Long curPpl;

    @Column(name="time")
    private Long time;

    @Column(name="password")
    private Long password;

    @Column(name="study_type")
    @Enumerated(EnumType.STRING)
    private StudyType studyType;

    @Column(name="start_at")
    private LocalDate startAt;

    @Column(name="end_at")
    private LocalDate endAt;

    @CreatedDate
    @Column(name="created_at", updatable = false)
    private LocalDateTime createdAt;

    @Column(name="user_code")
    private Long userCode;

    @Column(name="description")
    private String description;

    @Builder
    public Study(Long id, Long maxPpl,  Long curPpl, Long time, Long password, StudyType studyType,
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

    @Override
    public int compareTo(Study s){
        if(this.getCreatedAt().isBefore(s.getCreatedAt())) return 1;
        else if(this.getCreatedAt().equals(s.getCreatedAt())){
            if(this.getId()>s.getId()) return 1;
            return -1;
        }
        return -1;
    }
}