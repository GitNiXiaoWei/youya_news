package vo;

import lombok.Data;

@Data
public class ReplyVO {
    int replyid;
    int commentid;
    int replierid;//回复者id
    int userid;//被回复者id
    String replycontent;
    String replytime;
    //回复者信息
    String rusername;
    String ricon;
    //被回复者信息
    String rcusername;
}
