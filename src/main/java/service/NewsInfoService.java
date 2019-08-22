package service;


import pojo.NewsInfo;
import pojo.UserInfo;

import java.util.List;


public interface NewsInfoService {
//获取文章信息列表
    public List<NewsInfo> getAllNews();
//通过审核
    public boolean agreeByNewsId(int id);
//审核失败
    public boolean refuseByNewsId(int id);

}
