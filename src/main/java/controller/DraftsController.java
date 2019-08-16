package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pojo.DraftsInfo;
import service.DraftsInfoService;

import java.util.List;

@RestController
public class DraftsController {
    @Autowired
    DraftsInfoService draftsInfoService;

    @RequestMapping(name = "getAllDrafts",value = "getAllDrafts")
    public List<DraftsInfo> getAllDrafts(){
        List<DraftsInfo> allDrafts = draftsInfoService.getAllDrafts();
        System.out.println("allDrafts = " + allDrafts);
        return allDrafts;
    }
}
