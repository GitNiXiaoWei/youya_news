package controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import dto.CommentInfoDTO;
import dto.ReleaseSystemDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pojo.UserInfo;
import service.ReleaseSystemService;
import vo.CommentVO;
import vo.ReleaseSystemVO;
import vo.ReplyVO;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("ReleaseSystem")
public class ReleaseSystemController {
    @Autowired
    ReleaseSystemService releaseSystemService;

    static int defaultPageSize=6;

    /**
     * 通过新闻种类id获取所有新闻列表，分页
     * @param releaseSystemDTO
     * @return
     */
    @RequestMapping(name = "getAllNews",value = "/getAllNews")
    public Object getAllNews(@RequestBody ReleaseSystemDTO releaseSystemDTO){
        if (releaseSystemDTO.getCategoryname().equals("guoji")){
            releaseSystemDTO.setCategoryid(1);
        }else if (releaseSystemDTO.getCategoryname().equals("guonei")){
            releaseSystemDTO.setCategoryid(2);
        }else if (releaseSystemDTO.getCategoryname().equals("shishang")){
            releaseSystemDTO.setCategoryid(3);
        }else if (releaseSystemDTO.getCategoryname().equals("lvyou")){
            releaseSystemDTO.setCategoryid(4);
        }else if (releaseSystemDTO.getCategoryname().equals("youxi")){
            releaseSystemDTO.setCategoryid(5);
        }else if (releaseSystemDTO.getCategoryname().equals("jiaoyu")){
            releaseSystemDTO.setCategoryid(6);
        }else if (releaseSystemDTO.getCategoryname().equals("fangchan")){
            releaseSystemDTO.setCategoryid(7);
        }else if (releaseSystemDTO.getCategoryname().equals("qiche")){
            releaseSystemDTO.setCategoryid(8);
        }else if (releaseSystemDTO.getCategoryname().equals("yule")){
            releaseSystemDTO.setCategoryid(9);
        }else if (releaseSystemDTO.getCategoryname().equals("keji")){
            releaseSystemDTO.setCategoryid(10);
        }else if (releaseSystemDTO.getCategoryname().equals("caijing")){
            releaseSystemDTO.setCategoryid(11);
        }else if (releaseSystemDTO.getCategoryname().equals("tiyu")){
            releaseSystemDTO.setCategoryid(12);
        }
        PageHelper.startPage(releaseSystemDTO.getPageNum(),defaultPageSize);
        List<ReleaseSystemVO> allNewsListsByCategoryid = releaseSystemService.getAllNewsListsByCategoryid(releaseSystemDTO.getCategoryid());
        PageInfo<ReleaseSystemVO> systemVOPageInfo = new PageInfo<>(allNewsListsByCategoryid);
        return systemVOPageInfo;
    }

    /**
     * 新闻模糊查询功能，分页
     * @param releaseSystemDTO
     * @return
     */
    @RequestMapping(name = "searchAllNews",value = "/searchAllNews")
    public Object searchAllNews(@RequestBody ReleaseSystemDTO releaseSystemDTO){

        PageHelper.startPage(releaseSystemDTO.getPageNum(),defaultPageSize);
        List<ReleaseSystemVO> allNewsListsByCategoryid = releaseSystemService.searchAllNews(releaseSystemDTO);
        PageInfo<ReleaseSystemVO> systemVOPageInfo = new PageInfo<>(allNewsListsByCategoryid);
        return systemVOPageInfo;
    }

    /**
     * 通过newsid获取新闻详情
     * @param newsid
     * @return
     */
    @RequestMapping(name = "getNewsDetil",value = "/getNewsDetil")
    public Object getNewsDetil(@RequestParam int newsid){
        return releaseSystemService.getNewsDetailByNewsid(newsid);
    }

    /**
     * 通过新闻id获取所有评论信息
     * @param newsid
     * @return
     */
    @RequestMapping(name = "getAllComment",value = "/getAllComment")
    public Object getAllComment(@RequestParam int newsid){
        List<CommentVO> allCommentByNewsid = releaseSystemService.getAllCommentByNewsid(newsid);
        return allCommentByNewsid;
    }

    /**
     * 创建新评论
     * @param commentInfoDTO
     * @return
     */
    @RequestMapping(name = "createComment",value = "/createComment")
    public Object createComment(@RequestBody CommentInfoDTO commentInfoDTO){
        return releaseSystemService.insertComment(commentInfoDTO);
    }

    /**
     * 新建回复
     * @param commentInfoDTO
     * @return
     */
    @RequestMapping(name = "createReply",value = "/createReply")
    public Object createReply(@RequestBody CommentInfoDTO commentInfoDTO){
        System.out.println("commentInfoDTO = " + commentInfoDTO);
        int i = releaseSystemService.insertReply(commentInfoDTO);
        return i;
    }

    /**
     * 退出登录，清空session
     * @param session
     * @return
     */
    @RequestMapping(name = "signOut",value = "/signOut")
    public Object signOut(HttpSession session){
        session.removeAttribute("userInfo");
        System.out.println("signOut");
        return 1;
    }

    /**
     * 通过userid获取该用户的所有评论，分页
     * @param session
     * @return
     */
    @RequestMapping(name = "getCommentByUserid",value = "/getCommentByUserid")
    public Object getCommentByUserid(@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum, HttpSession session){
        UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");
        PageHelper.startPage(pageNum,defaultPageSize);
        List<CommentVO> commentByUserid = releaseSystemService.getCommentByUserid(userInfo.getUserid());
        PageInfo<CommentVO> commentVOPageInfo = new PageInfo<>(commentByUserid);
        return commentVOPageInfo;
    }

    /**
     * 通过userid获取被回复的信息，分页
     * @param pageNum
     * @param session
     * @return
     */
    @RequestMapping(name = "getReplyByUserid",value = "/getReplyByUserid")
    public Object getReplyByUserid(@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum, HttpSession session){
        UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");
        PageHelper.startPage(pageNum,defaultPageSize);
        List<ReplyVO> replyByUserid = releaseSystemService.getReplyByUserid(userInfo.getUserid());
        PageInfo<ReplyVO> replyVOPageInfo = new PageInfo<>(replyByUserid);
        return replyVOPageInfo;
    }

    /**
     * 通过userid获取最新的回复消息
     * @param id
     * @return
     */
    @RequestMapping(name = "getNewReply",value = "/getNewReply")
    public Object getNewReply(@RequestParam int id){
        return releaseSystemService.getNewReply(id);
    }

    /**
     * 通过userid将查看过后的回复消息置为1
     * @param id
     * @return
     */
    @RequestMapping(name = "lookedNewReply",value = "/lookedNewReply")
    public Object lookedNewReply(@RequestParam int id){
        return releaseSystemService.updateLookedNewReply(id);
    }
}
