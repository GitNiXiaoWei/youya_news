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


    @Override
    public List<NewsInfo> getAllNews() {
        return newsInfoMapper.getAllNews();
    }

    @Override
    public boolean agreeByNewsId(int id) {
        return this.newsInfoMapper.agreeByNewsId(id)>0;
    }

    @Override
    public boolean refuseByNewsId(int id) {
        return this.newsInfoMapper.refuseByNewsId(id)>0;
    }



}
