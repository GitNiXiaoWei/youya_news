package service;

import dto.UserInfoDTO;
import pojo.UserInfo;


public interface UserInfoService {
    public boolean register(UserInfoDTO userInfoDto);
    public UserInfo login(UserInfoDTO userInfoDto);

    public boolean informationUpdateByUsername(UserInfo userInfo);
}
