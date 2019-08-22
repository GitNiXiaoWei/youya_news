package dto;

import lombok.Data;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Data
public class DraftsInfoDTO {
    int newsid;
    int draftsid;
    String newscreatetime;
    String updatetime;
    String newstitle;
    String newscontent;
    String newssubtitle;
    int userid;
    String newsimg;
    //新闻类别
    int categoryid;
    String categoryname;
    //条件查询
    String clue1;
    String selects1;
    //分页
    String defaultValue="1";
    String value = "pageNum";
    Integer pageNum;
    //内文图片
    List<String> imgs;
    List<String> urls = new ArrayList<>();

    public DraftsInfoDTO() {
        SimpleDateFormat simpleDateFormat =new SimpleDateFormat("Y-M-d HH:mm:ss");
        newscreatetime = simpleDateFormat.format(System.currentTimeMillis());
    }

    public void addurls(String img){
        urls.add(img);
    }

}
