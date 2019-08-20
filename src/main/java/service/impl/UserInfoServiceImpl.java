package service.impl;

import dao.UserInfoMapper;
import dto.UserInfoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.UserInfo;
import service.UserInfoService;


@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    UserInfoMapper userInfoMapper;

    @Override
    public boolean register(UserInfoDTO userInfoDto) {
        UserInfo userInfos = userInfoMapper.selectByUserName(userInfoDto);
        if (userInfos!=null){
            return false;
        }else {
            int i = userInfoMapper.insertUser(userInfoDto);
            if (i>0) return true;
        }
        return false;
    }

    @Override
    public UserInfo login(UserInfoDTO userInfoDto) {
        UserInfo userInfo = userInfoMapper.selectByUserNameAndPassword(userInfoDto);
        if (userInfo!=null){
            return userInfo;
        }else {
            return null;
        }
    }

    @Override
    public boolean informationUpdateByUsername(UserInfo userInfo) {
        return userInfoMapper.informationUpdateByUsername(userInfo)>0;
    }
}
