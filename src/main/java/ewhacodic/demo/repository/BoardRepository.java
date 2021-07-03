package ewhacodic.demo.repository;

import ewhacodic.demo.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {
    //게시판별 조회
    @Query("select u From Post")
    List<Board> findPosts();

    @Query("select u From Post order by u.recommend")
    List<Board> OrderByRecommend();

    @Query("select u From Post u where u.category=:category order by u.view")
    List<Board> OrderByView();

    @Query("select u From Post u where u.category=:category order by u.id")
    List<Board> OrderByLatest();

    @Query("select u From Post u where u.category=:category order by u.reply")
    List<Board> OrderByReply();
}

