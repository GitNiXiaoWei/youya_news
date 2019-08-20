package service;

import pojo.DraftsInfo;
import pojo.UserInfo;
import vo.CategoryVO;
import vo.DraftsInfoVO;

import java.util.List;

public interface DraftsInfoService {
    public List<DraftsInfoVO> getAllDrafts(UserInfo userInfo);
    public int removeDraft(DraftsInfo draftsInfo);
    public DraftsInfoVO getDraftDetail(int id);
    public List<CategoryVO> getAllCategory();
}
