package service.impl;

import dao.NewsInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.NewsInfo;
import service.NewsInfoService;

import java.util.List;

@Service
public class NewsInfoServiceImpl  implements NewsInfoService {
    @Autowired
    NewsInfoMapper newsInfoMapper;

    /*
    * 获取所有文章信息列表
    * */
    @Override
    public List<NewsInfo> getAllNews() {
        return newsInfoMapper.getAllNews();
    }
    /*
    * 文章通过审核
    * */
    @Override
    public boolean agreeByNewsId(int id) {
        return this.newsInfoMapper.agreeByNewsId(id)>0;
    }
   /*
   * 文章审核失败
   * */
    @Override
    public boolean refuseByNewsId(int id) {
        return this.newsInfoMapper.refuseByNewsId(id)>0;
    }

    /*
    * 获取文章内容
    * */
    @Override
    public List<NewsInfo> showContent(int id) {
        return newsInfoMapper.showContent(id);
    }


}
