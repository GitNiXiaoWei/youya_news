package service.impl;

import dao.ApplicationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
    public boolean agreeByUserId(int id) {
        return this.applicationMapper.agreeByUserId(id)>0;
    }
    /*
    * 审核失败
    * */
    @Override
    public boolean refuseByUserId(int id) {
        return this.applicationMapper.refuseByUserId(id)>0;
    }
}
