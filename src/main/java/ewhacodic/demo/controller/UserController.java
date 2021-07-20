package ewhacodic.demo.controller;

import ewhacodic.demo.dto.UserInfoDto;
import ewhacodic.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import ewhacodic.demo.service.MailSendService;

@RequiredArgsConstructor
@Controller
public class UserController {

    private final UserService userService;

    @PostMapping("/user")
    public String signup(UserInfoDto infoDto) { // 회원 추가
        userService.save(infoDto);

        //메일 관련 기능 추가
        //임의의 authKey 생성 & 이메일 발송
        String authKey = mss.sendAuthMail(UserInfoDto.getEmail());
        UserInfoDto.setAuthKey(authKey);
        Map<String, String> map = new HashMap<String, String>();

        map.put("email", UserInfoDto.getEmail());
        map.put("authKey", UserInfoDto.getAuthKey());
        System.out.println(map);
        //DB에 authKey 업데이트
        //memberService.updateAuthKey(map);


        return "redirect:/login";
    }

    @GetMapping(value = "/logout")
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
        new SecurityContextLogoutHandler().logout(request, response, SecurityContextHolder.getContext().getAuthentication());
        return "redirect:/login";
    }
}