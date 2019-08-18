package vo;

import lombok.Data;

@Data
public class UserInfoVO {
    int userid;
    String username;
    String password;
    int sex;
    String email;
    String icon;
    int code;
}
