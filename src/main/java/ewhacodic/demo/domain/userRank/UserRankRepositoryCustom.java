package ewhacodic.demo.domain.userRank;

import java.time.LocalDate;
import java.util.List;


public interface UserRankRepositoryCustom {

    List<UserRank> findAllUserRankings(boolean week, LocalDate localDate);

}
