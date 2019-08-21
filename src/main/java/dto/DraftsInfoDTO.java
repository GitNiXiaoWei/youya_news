package dto;

import lombok.Data;

import java.text.SimpleDateFormat;

@Data
public class DraftsInfoDTO {
    int draftsid;
    String newscreatetime;
    String updatetime;
    String newstitle;
    String newscontext;
    String newssubtitle;
    int userid;
    String newsimg;
    //新闻类别
    int categoryid;
    String categoryname;
    //条件查询
    public String clue1;
    public String selects1;
    //分页
    String defaultValue="1";
    String value = "pageNum";
    Integer pageNum;

    public DraftsInfoDTO() {
        SimpleDateFormat simpleDateFormat =new SimpleDateFormat("Y-M-d HH:mm:ss");
        newscreatetime = simpleDateFormat.format(System.currentTimeMillis());
    }
}
