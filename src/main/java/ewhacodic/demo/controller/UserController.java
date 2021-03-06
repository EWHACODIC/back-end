package ewhacodic.demo.controller;

import ewhacodic.demo.dto.UserInfoDto;
import ewhacodic.demo.dto.UserTagDto;
import ewhacodic.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.Principal;
import java.util.Map;

@RequiredArgsConstructor
@Controller
public class UserController {

    @Autowired
    private final UserService userService;

    @PostMapping("/user")
    public String signup(UserInfoDto infoDto) { // νμ μΆκ°
        userService.save(infoDto);
        return "redirect:/login";
    }
    @GetMapping("/current_username")
    @ResponseBody
    public String currentUserName(Principal principal) {
        return principal.getName();
    }
    @GetMapping(value = "/logout")
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
        new SecurityContextLogoutHandler().logout(request, response, SecurityContextHolder.getContext().getAuthentication());
        return "redirect:/login";
    }

    @PostMapping("/api/user/tag/{userCode}")
    public ResponseEntity<String> updateUserTag(@PathVariable Long userCode, @RequestBody UserTagDto userTagDto) {
        userService.updateUserTag(userCode, userTagDto);
        return ResponseEntity.ok("Ok");
    }

}