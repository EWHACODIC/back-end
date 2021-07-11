package ewhacodic.demo.repository;

import ewhacodic.demo.domain.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserInfo, Long> {
    Optional<UserInfo> findByUserId(String userId);
}
// JpaRepository를 상속받아준다
// name으로 회원 조회하기 위한 함수도 생성