package vo;

import lombok.Data;

@Data
public class DraftsInfoVO {
    int newsid;
    int draftsid;
    String newscreatetime;
    String updatetime;
    String newstitle;
    String newscontent;
    String newssubtitle;
    long newsclicks;
    long newstalks;
    int newsstatus;
    int userid;
    String newsimg;
    //类别
    int categoryid;
    String categoryname;
    //图片
    String url;
}
