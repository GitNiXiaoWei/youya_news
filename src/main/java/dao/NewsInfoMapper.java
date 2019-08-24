package dao;

import pojo.NewsInfo;
import pojo.UserInfo;

import java.util.List;

public interface NewsInfoMapper {
    //获取所有文章列表
    public List<NewsInfo> getAllNews();
    //审核通过
    public int agreeByNewsId(int id);
    //审核失败
    public int refuseByNewsId(int id);
    //获取文章内容
    public List<NewsInfo> showContent(int id);


}
