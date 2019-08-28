package service.impl;

import dao.ApplicationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import service.ApplyService;
import vo.UserListVO;

import java.util.List;

@Service
public class ApplyServiceImpl implements ApplyService {
    /*
    * 获取所有用户申请信息列表
    * */
    @Autowired
    ApplicationMapper applicationMapper;
    @Override
    public List<UserListVO> listAllUserInfo() {
        return applicationMapper.listAllUserInfo();
    }
    /*
    *审核通过
    * */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean agreeByUserId(int id) {
        int i1 = applicationMapper.agreeByUserId(id);
        int i2 = applicationMapper.updateByUserId(id);
        return i1>0&i2>0;
    }
    /*
    * 审核失败
    * */
    @Override
    public boolean refuseByUserId(int id) {
        return this.applicationMapper.refuseByUserId(id)>0;
    }
}
