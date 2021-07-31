package ewhacodic.demo.controller;

import ewhacodic.demo.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api/email", method = {RequestMethod.GET, RequestMethod.POST},
        produces = "application/json; charset=UTF-8")
public class EmailController {

    private final EmailService emailService;

    @CrossOrigin(origins = "*")
    @PostMapping("/verify")
    public String sendEmail(@RequestBody String id) throws Exception {
        String addr = id+"@ewhain.net";
        String code = emailService.createKey(); //인증코드 생성
        try{
            emailService.sendSimpleMessage(addr, code); //코드 보내주고
        } catch (Exception e){
            e.printStackTrace();
        }
        return code; //코드 프론트로 보내주기 -> 프론트에서 입력받은 값과 비교하여 인증
    }
}