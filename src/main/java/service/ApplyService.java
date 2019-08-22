package service;

import vo.UserListVO;

import java.util.List;

public interface ApplyService {
    //获取用户申请列表
    public List<UserListVO> listAllUserInfo();

    public boolean agreeByUserId(int id);

    public boolean refuseByUserId(int id);
}
