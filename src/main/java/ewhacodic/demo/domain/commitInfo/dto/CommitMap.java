package ewhacodic.demo.domain.commitInfo.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@ToString
@Getter
@NoArgsConstructor
public class CommitMap {

    private Long commitCount;
    private LocalDate commitDate;

    @QueryProjection
    public CommitMap( Long commitCount, String yyyymmdd) {
        this.commitCount = commitCount;
        this.commitDate = LocalDate.parse(yyyymmdd, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

}
