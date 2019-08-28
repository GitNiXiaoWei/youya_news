package dto;

import lombok.Data;

@Data
public class CommentInfoDTO {
    //评论
    int newsid;
    int userid;
    String comment;
    //回复
    int commentid;
    int replierid;//回复者id
    String replycontent;//回复内容
}
