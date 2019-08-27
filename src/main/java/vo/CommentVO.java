package vo;

import lombok.Data;

import java.util.List;

@Data
public class CommentVO {
    int commentid;
    int newsid;
    int userid;
    String commentcontent;
    String commenttime;
    //评论者信息
    String cusername;
    String cicon;
    List<ReplyVO> replyVOList;
}
