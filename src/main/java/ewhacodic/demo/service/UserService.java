package ewhacodic.demo.service;

import ewhacodic.demo.domain.UserInfo;
import ewhacodic.demo.dto.TagDto;
import ewhacodic.demo.dto.UserInfoDto;
import ewhacodic.demo.dto.UserLikePostDto;
import ewhacodic.demo.dto.UserTagDto;
import ewhacodic.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final TagService tagService;

    public Long save(UserInfoDto infoDto) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        infoDto.setPassword(encoder.encode(infoDto.getPassword()));

        return userRepository.save(UserInfo.builder()
                .userName(infoDto.getUserName())
                .auth(infoDto.getAuth())
                .githubName(infoDto.getGithubName())
                .repoName(infoDto.getRepoName())
                .password(infoDto.getPassword()).build()).getCode();
    }


    public void updateUserTag(Long userCode, UserTagDto userTagDto) {
        UserInfo userInfo = userRepository.findOneByCode(userCode);
        userInfo.setTagIds(userTagDto.getTagIds());
        userRepository.save(userInfo);
    }

    public Set<Long> getUserTagIds(Long userCode) {
        UserInfo userInfo = userRepository.findOneByCode(userCode);
        return userInfo.getTagIds();
    }

    public Set<TagDto> getUserTagDtos(Long userCode) {
        UserInfo userInfo = userRepository.findOneByCode(userCode);
        Set<Long> tagIds = userInfo.getTagIds();
        return tagIds.stream().map(tagService::of).collect(Collectors.toSet());
    }

    public UserLikePostDto getUserLiktPostList(Long userCode) {
        UserInfo userInfo = userRepository.findOneByCode(userCode);
        return UserLikePostDto.of(userInfo);
    }

    // ?????????????????? ????????? ??????????????? ????????? ??? ???????????? ????????? ??????
    @Override // ???????????? ?????? ????????? UserDetails, UserDetails??? ???????????? User??? ?????? ?????? ?????? (???????????? ?????? ????????????)
    public UserInfo loadUserByUsername(String userName) throws UsernameNotFoundException {
        return userRepository.findByUserName(userName)
                .orElseThrow(() -> new UsernameNotFoundException((userName)));
    }
}