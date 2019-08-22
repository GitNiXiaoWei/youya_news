package dao;

import vo.UserListVO;

import java.util.List;

public interface ApplicationMapper {

    //作者审核
    public List<UserListVO> listAllUserInfo();

    public int agreeByUserId(int id);
    public int refuseByUserId(int id);
}
