package ewhacodic.demo.domain;

import ewhacodic.demo.dto.StudyDto;
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
import java.time.LocalTime;
import java.util.List;
import java.util.Set;

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

    @Column(name="title")
    private String title;

    @Column(name="max_ppl")
    private Long maxPpl;

    @Column(name="cur_ppl")
    private Long curPpl;

    @Column(name="time")
    private Long time;

    @Column(name="password")
    private Long password;

    @Column(name="day1")
    private String day1;

    @Column(name="day2")
    private String day2;

    @Column(name="start_time")
    private LocalTime startTime;

    @Column(name="end_time")
    private LocalTime endTime;

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
    private String userCode;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(
            name="user_list",
            joinColumns={
                    @JoinColumn(name="study_id")
            }
    )
    @Column(name="user_id", nullable = false)
    private Set<String> userList;

    @Column(name="description")
    private String description;

    @Builder
    public Study(Long id, String title, Long maxPpl,  Long curPpl, Long time, Long password,
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

    @Override
    public int compareTo(Study s){
        if(this.getCreatedAt().isBefore(s.getCreatedAt())) return 1;
        else if(this.getCreatedAt().equals(s.getCreatedAt())){
            if(this.getId()>s.getId()) return 1;
            return -1;
        }
        return -1;
    }

    public Study updateMember(String userId, Long password){
        if(this.getCurPpl() == this.getMaxPpl() || !password.equals(this.getPassword())) return null;
        Set<String> userList = this.getUserList();
        userList.add(userId);
        this.setUserList(userList);
        this.setCurPpl(this.getUserList().stream().count());

        return this;
    }
}