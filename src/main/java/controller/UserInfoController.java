package controller;

import dto.UserInfoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pojo.UserInfo;
import service.UserInfoService;
import util.SendMail;

import javax.servlet.http.HttpSession;
import java.util.Random;

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
    @ResponseBody
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
    @RequestMapping(name = "getCode",value = "/getCode")
    @ResponseBody
    public Object getCode(@RequestParam String email) throws Exception {
        System.err.println("email = " + email);
        SendMail sendMail = new SendMail();
        sendMail.setReceiveMailAccount(email);
        Random random = new Random();
        int i = random.nextInt(9000)+1000;
        sendMail.run(i);
        System.err.println("i :"+i);
        return i;
    }

    @RequestMapping(name = "loginCheck",value = "/loginCheck")
    @ResponseBody
    public Object login(@RequestBody UserInfoDTO userInfoDto, HttpSession httpSession){
        System.out.println("userInfoDto = " + userInfoDto);
        UserInfo login = userInfoService.login(userInfoDto);
        if (login!=null){
            httpSession.setAttribute("userInfo",login);
            return "true";
        }else {
            return "false";
        }
    }

}
