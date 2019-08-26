package pojo;

import lombok.Data;

@Data
public class UserInfo {
    int userid;
    String username;
    String password;
    int sex;
    String email;
    String icon;
    //角色
    int roleid;
    String rolename;
}
