package controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.NewsInfoService;

@RestController
@RequestMapping("administrator")
public class NewsInfoController {

    @Autowired
    NewsInfoService newsInfoService;
    /*
    * 获取所有文章信息列表
    * */
    @RequestMapping("listAllNewsInfo")
    public Object listAllNewsInfo(){
        return newsInfoService.getAllNews();
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
