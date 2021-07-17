package ewhacodic.demo.repository;

import ewhacodic.demo.domain.Board;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


public interface BoardRepository extends JpaRepository<Board, Long> {
    List<Board> findByTitleContaining(String keyword);

    List<Board> findByTag1OrTag2(String tag1, String tag2);
//    @Query("select u From Board order by u.recommend")
//    List<Board> OrderByRecommend();
//
//    //@Query("select u From Board order by u.view")
//    List<Board> OrderByView();
//
//    //@Query("select u From Board order by u.id")
//    List<Board> OrderByLatest();
//
//    //@Query("select u From Board order by u.reply")
//    List<Board> OrderByReply();

}

