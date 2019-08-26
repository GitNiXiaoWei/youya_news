package dto;

import lombok.Data;

@Data
public class ReleaseSystemDTO {
    //分页
    String defaultValue="1";
    String value = "pageNum";
    Integer pageNum;
    //新闻种类
    int categoryid;
    String categoryname;
    //搜索关键字
    String search;
}
