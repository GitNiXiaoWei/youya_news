package service.impl;

import dao.UserInfoMapper;
import dto.UserInfoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.UserInfo;
import service.UserInfoService;

import java.util.List;

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
}
