package ewhacodic.demo.domain.commitInfo.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class WeekDayStat {

    private Long count;
    private Integer weekDay;

    @QueryProjection
    public WeekDayStat(Long count, Integer weekDay) {
        this.count = count;
        this.weekDay = weekDay;
    }

}
