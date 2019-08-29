package controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pojo.NewsInfo;
import service.NewsInfoService;

import java.util.List;

@RestController
@RequestMapping("administrator")
public class NewsInfoController {

    @Autowired
    NewsInfoService newsInfoService;
    /*
    * 获取所有文章信息列表以及分页
    * */
    @RequestMapping("listAllNewsInfo")
    public Object listAllNewsInfo(@RequestParam(required=true,defaultValue="1",value="pageNum")Integer pageNum){
        //一页有多少条
        int defaultPageSize=6;
        //初始化pageHelper对象
        PageHelper.startPage(pageNum,defaultPageSize);
        List<NewsInfo> allNews = newsInfoService.getAllNews();
        PageInfo<NewsInfo> newsInfoPageInfo = new PageInfo<>(allNews);
        return newsInfoPageInfo;
    }
    /*
    * 审核通过 文章上架
    * */
    @RequestMapping("agreeByNewsId")
    public Object agreeByNewsId(@RequestParam int newsid){
        System.out.println("id="+newsid);
        return this.newsInfoService.agreeByNewsId(newsid);
    }
    /*
    * 审核失败 文章下架
    * */
    @RequestMapping("refuseByNewsId")
    public Object refuseByNewsId(@RequestParam int newsid){
        System.out.println("id="+newsid);
        return this.newsInfoService.refuseByNewsId(newsid);
    }

    /*
    * 获取文章内容
    * */
    @RequestMapping("showContent")
    public Object showContent(@RequestParam int newsid){
        System.out.println("id="+newsid);
        return newsInfoService.showContent(newsid);
    }
}
