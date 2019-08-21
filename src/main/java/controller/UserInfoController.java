package controller;

import dto.ApplicationDTO;
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
        Random random = new Random();
        int i = random.nextInt(9000)+1000;
        SendMail sendMail = new SendMail();
        sendMail.setReceiveMailAccount(email);
        sendMail.run(i);
        System.err.println("i :"+i);
        return i;
    }

    /**
     * 用户登录
     * @param userInfoDto
     * @param httpSession
     * @return
     */
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

    /**
     * 获取登录信息
     * @param httpSession
     * @return
     */
    @RequestMapping(name = "initUser",value = "/initUser")
    @ResponseBody
    public Object initUser( HttpSession httpSession){
        Object userInfo = httpSession.getAttribute("userInfo");
        if ( userInfo==null){
            return null;
        }else {
            return userInfo;
        }
    }

    /**
     * 获取个人信息及其更改
     * @param userInfoDTO
     * @return
     */
    @RequestMapping("informationUpdateByUsername")
    @ResponseBody
    public Object informationUpdateByUsername(@RequestBody UserInfoDTO userInfoDTO) {
        return userInfoService.informationUpdateByUserName(userInfoDTO);
    }

    /**
     * 权限申请
     *
     * @param applicationDTO
     * @return
     */
    @RequestMapping("applicationauthority")
    @ResponseBody
    public Object applicationauthority(@RequestBody ApplicationDTO applicationDTO,HttpSession httpSession) {
        UserInfo userinfo = (UserInfo)httpSession.getAttribute("userInfo");
        applicationDTO.setUserid(userinfo.getUserid());
        return userInfoService.applicationauthority(applicationDTO);
    }

    /**
     * 查询application中是否存在id
     * @param userid
     * @return
     */
    @RequestMapping("selectApplicationByUserid")
    @ResponseBody
    public Object selectApplicationByUserid(@RequestParam int userid) {
        if(userInfoService.selectApplicationByUserid(userid)){
            return "you";
        }else {
            return "wu";
        }
    }
}
