package dao;

import dto.DraftsInfoDTO;
import pojo.DraftsInfo;
import pojo.UserInfo;
import vo.CategoryVO;
import vo.DraftsInfoVO;

import java.util.List;

public interface DraftsInfoMapper {
    public List<DraftsInfoVO> getAllDrafts(UserInfo userInfo);
    public int removeDraft(DraftsInfoDTO draftsInfoDTO);
    public DraftsInfoVO getDraftDetail(int id);
    public List<CategoryVO> getAllCategory();
    public int updateDraft(DraftsInfoDTO draftsInfoDTO);
    public int updateDraftsCategory(DraftsInfoDTO draftsInfoDTO);
    public List<DraftsInfo> selectDraftsByClue(DraftsInfoDTO draftsInfoDTO);
    public int insertDraft(DraftsInfoDTO draftsInfoDTO);
    public int insertDraftsCategory(DraftsInfoDTO draftsInfoDTO);
    public int insertDraftsImgs(DraftsInfoDTO draftsInfoDTO);
    public int insertNewsImgs(DraftsInfoDTO draftsInfoDTO);
    public int insertNews(DraftsInfoDTO draftsInfoDTO);
    public int insertNewsCategory(DraftsInfoDTO draftsInfoDTO);
    public List<DraftsInfoVO> selectImgsByDraftsid(DraftsInfoDTO draftsInfoDTO);
    public int insertNewsImgsByDrafts(DraftsInfoDTO draftsInfoDTO);
    public List<DraftsInfoVO> getAllNewsByUserid(DraftsInfoDTO draftsInfoDTO);
    public int removeNewsByNewsid(DraftsInfoDTO draftsInfoDTO);
    public List<DraftsInfoVO> selectNewsByClue(DraftsInfoDTO draftsInfoDTO);
}
