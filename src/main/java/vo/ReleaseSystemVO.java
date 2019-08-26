package vo;

import lombok.Data;

@Data
public class ReleaseSystemVO {
    int newsid;
    String newstitle;
    String newscontent;
    String newscreatetime;
    String newssubtitle;
    int newsclicks;
    int newstalks;
    String newsimg;
    //作者
    int userid;
    String username;
    String email;
    String icon;
}
