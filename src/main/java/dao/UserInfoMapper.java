package dao;

import pojo.UserInfo;

import java.util.List;

public interface UserInfoMapper {
    public List<UserInfo> selectByUserName();
    public int insertUser();
}
