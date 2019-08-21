package vo;

import lombok.Data;

@Data
public class DraftsInfoVO {
    int draftsid;
    String newscreatetime;
    String updatetime;
    String newstitle;
    String newscontent;
    String newssubtitle;
    int userid;
    String newsimg;
    //类别
    int categoryid;
    String categoryname;
}
