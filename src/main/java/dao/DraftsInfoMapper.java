package dao;

import pojo.DraftsInfo;
import pojo.UserInfo;
import vo.DraftsInfoVO;

import java.util.List;

public interface DraftsInfoMapper {
    public List<DraftsInfoVO> getAllDrafts(UserInfo userInfo);
    public int removeDraft(DraftsInfo draftsInfo);
}
