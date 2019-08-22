package controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.NewsInfoService;

@RestController
@RequestMapping("administrator")
public class NewsInfoController {

    @Autowired
    NewsInfoService newsInfoService;

    @RequestMapping("listAllNewsInfo")
    public Object listAllNewsInfo(){
        return newsInfoService.getAllNews();
    }

    @RequestMapping("agreeByNewsId")
    public Object agreeByNewsId(@RequestParam int newsid){
        System.out.println("id="+newsid);
        return this.newsInfoService.agreeByNewsId(newsid);
    }

    @RequestMapping("refuseByNewsId")
    public Object refuseByNewsId(@RequestParam int newsid){
        System.out.println("id="+newsid);
        return this.newsInfoService.refuseByNewsId(newsid);
    }

}
