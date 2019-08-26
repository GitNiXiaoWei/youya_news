package controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import dto.ReleaseSystemDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
        if (releaseSystemDTO.getCategoryname().equals("guonei")){
            releaseSystemDTO.setCategoryid(2);
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
}
