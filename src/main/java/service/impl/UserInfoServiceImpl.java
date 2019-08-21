package service.impl;

import dao.UserInfoMapper;
import dto.ApplicationDTO;
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
    public boolean informationUpdateByUserName(UserInfoDTO userInfoDTO) {
        UserInfo userInfo1 = userInfoMapper.selectByUserName(userInfoDTO);
        if (userInfo1!=null){
            return false;
        }
        return userInfoMapper.informationUpdateByUsername(userInfoDTO)>0;
    }

    @Override
    public boolean applicationauthority(ApplicationDTO applicationDTO) {
        return userInfoMapper.applicationauthority(applicationDTO);
    }

    @Override
    public boolean selectApplicationByUserid(int userid) {
        ApplicationDTO applicationDTO = userInfoMapper.selectApplicationByUserid(userid);
            if(applicationDTO!=null){
                return true;
            }
            return false;
    }

}
