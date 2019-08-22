package service;

import dto.ApplicationDTO;
import dto.UserInfoDTO;
import pojo.UserInfo;


public interface UserInfoService {
    public boolean register(UserInfoDTO userInfoDto);
    public UserInfo login(UserInfoDTO userInfoDto);

    public boolean informationUpdateByUserName(UserInfoDTO userInfoDTO);

    public boolean applicationauthority(ApplicationDTO applicationDTO);

    public boolean selectApplicationByUserid(int userid);
}
