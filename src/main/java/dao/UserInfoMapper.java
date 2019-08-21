package dao;

import dto.ApplicationDTO;
import dto.UserInfoDTO;
import pojo.UserInfo;

public interface UserInfoMapper {
    public UserInfo selectByUserName(UserInfoDTO userInfoDTO);
    public int insertUser(UserInfoDTO userInfoDTO);
    public UserInfo selectByUserNameAndPassword(UserInfoDTO userInfoDTO);

    public int informationUpdateByUsername(UserInfoDTO userInfoDTO);

    public boolean applicationauthority(ApplicationDTO applicationDTO);

    public ApplicationDTO selectApplicationByUserid(int userid);
}
