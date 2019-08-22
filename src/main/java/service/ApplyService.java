package service;

import vo.UserListVO;

import java.util.List;

public interface ApplyService {
    //获取用户申请列表
    public List<UserListVO> listAllUserInfo();
    //审核通过 成为小编
    public boolean agreeByUserId(int id);
    //审核失败
    public boolean refuseByUserId(int id);
}
