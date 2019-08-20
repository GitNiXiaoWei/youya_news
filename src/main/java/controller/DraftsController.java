package controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import dto.DraftsInfoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pojo.DraftsInfo;
import pojo.UserInfo;
import service.DraftsInfoService;
import vo.CategoryVO;
import vo.DraftsInfoVO;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class DraftsController {
    @Autowired
    DraftsInfoService draftsInfoService;

    /**
     * 获取所有草稿
     * @param pageNum
     * @param session
     * @return
     */
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

    /**
     * 获取草稿内容
     * @param id
     * @return
     */
    @RequestMapping(name = "getDraftDetail",value = "getDraftDetail")
    public Object getDraftDetail(@RequestParam int id){
        DraftsInfoVO draftDetail = draftsInfoService.getDraftDetail(id);
        System.err.println("draftDetail = " + draftDetail);
        return draftDetail;
    }

    /**
     * 删除草稿
     * @param draftsInfo
     * @return
     */
    @RequestMapping(name = "removeDraft",value = "removeDraft")
    public Object removeDraft(@RequestBody DraftsInfo draftsInfo){
        int i = draftsInfoService.removeDraft(draftsInfo);
        return i;
    }

    /**
     * 获取所有新闻种类
     * @return
     */
    @RequestMapping(name = "getAllCategory",value = "getAllCategory")
    public Object getAllCategory(){
        List<CategoryVO> allCategory = draftsInfoService.getAllCategory();
        return allCategory;
    }

    /**
     * 更新草稿
     * @param draftsInfoDTO
     * @return
     */
    @RequestMapping(name = "updateDraft",value = "updateDraft")
    public Object updateDraft(@RequestBody DraftsInfoDTO draftsInfoDTO){

        return draftsInfoService.updateDraft(draftsInfoDTO);
    }
}
