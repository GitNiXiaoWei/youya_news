package controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pojo.DraftsInfo;
import pojo.UserInfo;
import service.DraftsInfoService;
import vo.DraftsInfoVO;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class DraftsController {
    @Autowired
    DraftsInfoService draftsInfoService;

    @RequestMapping(name = "getAllDrafts",value = "getAllDrafts")
    public Object getAllDrafts(@RequestParam(required = true,defaultValue = "1",value = "pageNum")Integer pageNum, HttpSession session){
        int defaultPageSize = 8;
        PageHelper.startPage(pageNum,defaultPageSize);

        Object userInfo = session.getAttribute("userInfo");
        List<DraftsInfoVO> allDrafts = draftsInfoService.getAllDrafts((UserInfo) userInfo);
        PageInfo<DraftsInfoVO> userInfoPageInfo =new PageInfo<DraftsInfoVO>(allDrafts);
        System.out.println("allDrafts = " + allDrafts);
        return userInfoPageInfo;
    }

    @RequestMapping(name = "getDraftDetail",value = "getDraftDetail")
    public Object getDraftDetail(@RequestParam int id){
        return null;
    }

    @RequestMapping(name = "removeDraft",value = "removeDraft")
    public Object removeDraft(@RequestBody DraftsInfo draftsInfo){
        int i = draftsInfoService.removeDraft(draftsInfo);
        return i;
    }
}
