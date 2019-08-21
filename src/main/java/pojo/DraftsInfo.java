package pojo;

import lombok.Data;

@Data
public class DraftsInfo {
    int draftsid;
    String newscreatetime;
    String updatetime;
    String newstitle;
    String newscontent;
    String newssubtitle;
    int userid;
    String newsimg;
}
