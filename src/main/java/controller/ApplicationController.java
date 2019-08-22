package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import service.ApplyService;

@RestController
@RequestMapping("administrator")
public class ApplicationController {
    @Autowired
    ApplyService applyService;

    /*
    * 获取所有用户申请信息列表
    * */
    @RequestMapping("listAllUserInfo")
    public Object listAllUserInfo(){
        return applyService.listAllUserInfo();
    }

    /*
    * 审核通过 该用户成为小编
    * */
    @RequestMapping("agreeByUserId")
    public Object agreeByNewsId(@RequestParam int userid){
//        System.out.println("id="+userid);
        return this.applyService.agreeByUserId(userid);
    }

    /*
    * 审核失败
    * */
    @RequestMapping("refuseByUserId")
    public Object refuseByNewsId(@RequestParam int userid){
//        System.out.println("id="+userid);
        return this.applyService.refuseByUserId(userid);
    }

}
