package ewhacodic.demo.service;

import ewhacodic.demo.domain.UserInfo;
import ewhacodic.demo.dto.UserInfoDto;
import ewhacodic.demo.dto.UserTagDto;
import ewhacodic.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

import static org.eclipse.jdt.internal.compiler.problem.ProblemSeverities.Optional;

@RequiredArgsConstructor
@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    public Long save(UserInfoDto infoDto) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        infoDto.setPassword(encoder.encode(infoDto.getPassword()));

        return userRepository.save(UserInfo.builder()
                .userId(infoDto.getUserId())
                .auth(infoDto.getAuth())
                .password(infoDto.getPassword()).build()).getCode();
    }

    public void updateUserTag(UserTagDto userTagDto) {
       Optional<UserInfo> userInfo = userRepository.findByUserId(userTagDto.getUserId());
       userInfo.ifPresent(it -> {
           it.setTagIds(userTagDto.getTagIds());
           userRepository.save(it);
       });
    }

    public Set<Long> getUserTagIds(String userId) {
        Optional<UserInfo> userInfo = userRepository.findByUserId(userId);
        return userInfo.get().getTagIds();
    }

    // 시큐리티에서 지정한 서비스이기 때문에 이 메소드를 필수로 구현
    @Override // 기본적인 반환 타입은 UserDetails, UserDetails를 상속받은 User로 반환 타입 지정 (자동으로 다운 캐스팅됨)
    public UserInfo loadUserByUsername(String userId) throws UsernameNotFoundException {
        return userRepository.findByUserId(userId)
                .orElseThrow(() -> new UsernameNotFoundException((userId)));
    }
}