package service.impl;

import dao.ApplicationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.ApplyService;
import vo.UserListVO;

import java.util.List;

@Service
public class ApplyServiceImpl implements ApplyService {

    @Autowired
    ApplicationMapper applicationMapper;
    @Override
    public List<UserListVO> listAllUserInfo() {
        return applicationMapper.listAllUserInfo();
    }

    @Override
    public boolean agreeByUserId(int id) {
        return this.applicationMapper.agreeByUserId(id)>0;
    }

    @Override
    public boolean refuseByUserId(int id) {
        return this.applicationMapper.refuseByUserId(id)>0;
    }
}
