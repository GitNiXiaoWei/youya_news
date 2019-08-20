package service.impl;

import dao.DraftsInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.DraftsInfo;
import pojo.UserInfo;
import service.DraftsInfoService;
import vo.DraftsInfoVO;

import java.util.List;

@Service
public class DraftsInfoServiceImpl implements DraftsInfoService {

    @Autowired
    DraftsInfoMapper draftsInfoMapper;

    public List<DraftsInfoVO> getAllDrafts(UserInfo userInfo){
       return draftsInfoMapper.getAllDrafts(userInfo);
    }


    @Override
    public int removeDraft(DraftsInfo draftsInfo) {

        return draftsInfoMapper.removeDraft(draftsInfo);
    }

}
