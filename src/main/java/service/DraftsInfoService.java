package service;

import dto.DraftsInfoDTO;
import pojo.DraftsInfo;
import pojo.UserInfo;
import vo.CategoryVO;
import vo.DraftsInfoVO;

import java.util.List;

public interface DraftsInfoService {
    public List<DraftsInfoVO> getAllDrafts(UserInfo userInfo);
    public int removeDraft(DraftsInfoDTO draftsInfoDTO);
    public DraftsInfoVO getDraftDetail(int id);
    public List<CategoryVO> getAllCategory();
    public int updateDraft(DraftsInfoDTO draftsInfoDTO);
    public List<DraftsInfo> selectDraftsByClue(DraftsInfoDTO draftsInfoDTO);
    public int createDraft(DraftsInfoDTO draftsInfoDTO);
    public int insertNews(DraftsInfoDTO draftsInfoDTO);
}
