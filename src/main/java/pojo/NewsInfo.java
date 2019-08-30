package pojo;


import lombok.Data;

@Data
public class NewsInfo {

   int newsid;
   int userid;
   String newstitle;
   String newscontent;
   String newscreatetime;
   String newssubtitle;
   int newsclicks;
   int newstalks;
   String newsimg;

   String username;


}
