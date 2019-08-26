package controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import dto.ReleaseSystemDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import service.NewsInfoService;
import service.ReleaseSystemService;
import vo.ReleaseSystemVO;

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
     * 新闻查询功能，分页
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
}
