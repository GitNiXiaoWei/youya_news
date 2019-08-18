package controller;

import dto.UserInfoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.UserInfoService;
import util.SendMail;

@Controller
public class UserInfoController {

    @Autowired
    UserInfoService userInfoService;

    /**
     * 注册
     * @param userInfoDto
     * @return
     */
    @RequestMapping(name = "register",value = "/register")
    public Object register(@RequestBody UserInfoDTO userInfoDto){
        if (userInfoDto.getPassword()!="" && userInfoDto.getUsername()!=""){
            boolean register = userInfoService.register(userInfoDto);
            if (register) return "true";
            else return "false";
        }else {
            return "1";
        }
    }


    /**
     * 获取邮箱验证码
     * @param email
     * @return
     * @throws Exception
     */
    @RequestMapping(name = "getCode",value = "getCode")
    public Object getCode(@RequestParam String email) throws Exception {
        SendMail sendMail = new SendMail();
        sendMail.setReceiveMailAccount(email);
        int run = sendMail.run();
        return run;
    }

}
