package dao;

import vo.UserListVO;

import java.util.List;

public interface ApplicationMapper {

    //获取所有用户申请信息列表
    public List<UserListVO> listAllUserInfo();
    //审核通过
    public int agreeByUserId(int id);
    //审核失败
    public int refuseByUserId(int id);
}
