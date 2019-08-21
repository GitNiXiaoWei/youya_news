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
    //条件查询
    public String clue1;
    public String selects1;
    //分页
    String defaultValue="1";
    String value = "pageNum";
    Integer pageNum;
}
