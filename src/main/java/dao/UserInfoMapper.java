package dao;

import dto.UserInfoDTO;
import pojo.UserInfo;

public interface UserInfoMapper {
    public UserInfo selectByUserName(UserInfoDTO userInfoDTO);
    public int insertUser(UserInfoDTO userInfoDTO);
}
