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

    @RequestMapping("listAllUserInfo")
    public Object listAllUserInfo(){
        return applyService.listAllUserInfo();
    }

    @RequestMapping("agreeByUserId")
    public Object agreeByNewsId(@RequestParam int userid){
        System.out.println("id="+userid);
        return this.applyService.agreeByUserId(userid);
    }

    @RequestMapping("refuseByUserId")
    public Object refuseByNewsId(@RequestParam int userid){
        System.out.println("id="+userid);
        return this.applyService.refuseByUserId(userid);
    }

}
