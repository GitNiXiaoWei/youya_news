package dto;

import lombok.Data;

@Data
public class UserInfoDTO {
    int userid;
    String username;
    String password;
    int sex;
    String email;
    String icon;
    int code;
}
