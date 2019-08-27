package dto;

import lombok.Data;

@Data
public class CommentInfoDTO {
    int newsid;
    int userid;
    String comment;
}
