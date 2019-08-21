package dao;

import dto.DraftsInfoDTO;
import pojo.DraftsInfo;
import pojo.UserInfo;
import vo.CategoryVO;
import vo.DraftsInfoVO;

import java.util.List;

public interface DraftsInfoMapper {
    public List<DraftsInfoVO> getAllDrafts(UserInfo userInfo);
    public int removeDraft(DraftsInfo draftsInfo);
    public DraftsInfoVO getDraftDetail(int id);
    public List<CategoryVO> getAllCategory();
    public int updateDraft(DraftsInfoDTO draftsInfoDTO);
    public int updateDraftsCategory(DraftsInfoDTO draftsInfoDTO);
    public List<DraftsInfo> selectDraftsByClue(DraftsInfoDTO draftsInfoDTO);
}
