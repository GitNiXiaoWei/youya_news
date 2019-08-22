package dao;

import pojo.NewsInfo;
import pojo.UserInfo;

import java.util.List;

public interface NewsInfoMapper {
//文章审核
    public List<NewsInfo> getAllNews();
    public int agreeByNewsId(int id);
    public int refuseByNewsId(int id);


}
