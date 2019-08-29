package controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import service.ApplyService;
import vo.UserListVO;

import java.util.List;

@RestController
@RequestMapping("administrator")
public class ApplicationController {
    @Autowired
    ApplyService applyService;

    /*
    * 获取所有用户申请信息列表以及分页
    * */
    @RequestMapping("listAllUserInfo")
    public Object listAllUserInfo(@RequestParam(required=true,defaultValue="1",value="pageNum")Integer pageNum){
        //一页有多少条
        int defaultPageSize=6;
        //初始化pageHelper对象
        PageHelper.startPage(pageNum,defaultPageSize);
        List<UserListVO> userListVOS = applyService.listAllUserInfo();
        PageInfo<UserListVO> userListVOPageInfo = new PageInfo<>(userListVOS);
        return userListVOPageInfo;
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
