package controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pojo.DraftsInfo;
import service.DraftsInfoService;

import java.util.List;

@RestController
public class DraftsController {
    @Autowired
    DraftsInfoService draftsInfoService;

    @RequestMapping(name = "getAllDrafts",value = "getAllDrafts")
    public Object getAllDrafts(@RequestParam(required = true,defaultValue = "1",value = "pageNum")Integer pageNum){
        int defaultPageSize = 8;
        PageHelper.startPage(pageNum,defaultPageSize);

        List<DraftsInfo> allDrafts = draftsInfoService.getAllDrafts();
        PageInfo<DraftsInfo> userInfoPageInfo =new PageInfo<DraftsInfo>(allDrafts);
        System.out.println("allDrafts = " + allDrafts);
        return userInfoPageInfo;
    }

    @RequestMapping(name = "removeDraft",value = "removeDraft")
    public Object removeDraft(@RequestBody DraftsInfo draftsInfo){
        return null;
    }
}
