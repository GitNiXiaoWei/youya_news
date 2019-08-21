package service.impl;

import dao.DraftsInfoMapper;
import dto.DraftsInfoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.DraftsInfo;
import pojo.UserInfo;
import service.DraftsInfoService;
import vo.CategoryVO;
import vo.DraftsInfoVO;

import java.util.List;

@Service
public class DraftsInfoServiceImpl implements DraftsInfoService {

    @Autowired
    DraftsInfoMapper draftsInfoMapper;

    public List<DraftsInfoVO> getAllDrafts(UserInfo userInfo){
       return draftsInfoMapper.getAllDrafts(userInfo);
    }


    @Override
    public int removeDraft(DraftsInfo draftsInfo) {
        return draftsInfoMapper.removeDraft(draftsInfo);
    }

    @Override
    public DraftsInfoVO getDraftDetail(int id) {
        return draftsInfoMapper.getDraftDetail(id);
    }

    @Override
    public List<CategoryVO> getAllCategory() {
        return draftsInfoMapper.getAllCategory();
    }

    /**
     * 更新草稿
     * @param draftsInfoDTO
     * @return
     */
    @Override
    public int updateDraft(DraftsInfoDTO draftsInfoDTO) {
        int i = draftsInfoMapper.updateDraft(draftsInfoDTO);
        int i1 = draftsInfoMapper.updateDraftsCategory(draftsInfoDTO);
        int i2 = draftsInfoMapper.insertDraftsImgs(draftsInfoDTO);
        if (i>0&&i1>0&&i2>0){
            return 1;
        }else {
            return 0;
        }
    }

    @Override
    public List<DraftsInfo> selectDraftsByClue(DraftsInfoDTO draftsInfoDTO) {
        List<DraftsInfo> draftsInfos = draftsInfoMapper.selectDraftsByClue(draftsInfoDTO);
        return draftsInfos;
    }

    /**
     * 新增草稿
     * @param draftsInfoDTO
     * @return
     */
    @Override
    public int createDraft(DraftsInfoDTO draftsInfoDTO) {
        int i = draftsInfoMapper.insertDraft(draftsInfoDTO);
        //插入drafts表后自增生成id，并且自动set到bean中
        int i1 = draftsInfoMapper.insertDraftsCategory(draftsInfoDTO);
        int i2 = draftsInfoMapper.insertDraftsImgs(draftsInfoDTO);
        if (i>0&&i1>0&&i2>0){
            return 1;
        }else {
            return 0;
        }
    }

    /**
     * 新增上传新闻
     * @param draftsInfoDTO
     * @return
     */
    @Override
    public int insertNews(DraftsInfoDTO draftsInfoDTO) {
        int i = draftsInfoMapper.insertNews(draftsInfoDTO);
        int i1 = draftsInfoMapper.insertNewsImgs(draftsInfoDTO);
        int i2 = draftsInfoMapper.insertNewsCategory(draftsInfoDTO);
        if (i>0&&i1>0&&i2>0){
            return 1;
        }else {
            return 0;
        }
    }

}
