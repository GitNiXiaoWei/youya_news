package dto;

import lombok.Data;

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
    //类别
    int categoryid;
    String categoryname;
}
