package service.impl;

import dao.DraftsInfoMapper;
import dto.DraftsInfoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import pojo.DraftsInfo;
import pojo.UserInfo;
import service.DraftsInfoService;
import vo.CategoryVO;
import vo.DraftsInfoVO;

import java.util.HashMap;
import java.util.List;

@Service
public class DraftsInfoServiceImpl implements DraftsInfoService {

    @Autowired
    DraftsInfoMapper draftsInfoMapper;

    public List<DraftsInfoVO> getAllDrafts(UserInfo userInfo){
       return draftsInfoMapper.getAllDrafts(userInfo);
    }


    @Override
    public int removeDraft(DraftsInfoDTO draftsInfoDTO) {
        return draftsInfoMapper.removeDraft(draftsInfoDTO);
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
        if (draftsInfoDTO.getImgs().size()>0){
            int i2 = draftsInfoMapper.insertDraftsImgs(draftsInfoDTO);
        }
        if (i>0&&i1>0){
            return 1;
        }else {
            return 0;
        }
    }

    /**
     * 通过条件模糊查询草稿
     * @param draftsInfoDTO
     * @return
     */
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
        //插入drafts表后自增生成draftsid，并且自动set到bean中
        int i1 = draftsInfoMapper.insertDraftsCategory(draftsInfoDTO);
        if (draftsInfoDTO.getImgs().size()>0){
            int i2 = draftsInfoMapper.insertDraftsImgs(draftsInfoDTO);
        }
        if (i>0&&i1>0){
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
    @Transactional(propagation = Propagation.REQUIRED)
    public int insertNews(DraftsInfoDTO draftsInfoDTO) {
        int i = draftsInfoMapper.insertNews(draftsInfoDTO);
        //插入news表后自增生成newsid，并且自动set到bean中
        int i1 = draftsInfoMapper.insertNewsCategory(draftsInfoDTO);
        if (draftsInfoDTO.getImgs().size()>0){
            int i2 = draftsInfoMapper.insertNewsImgs(draftsInfoDTO);
        }
        if (draftsInfoDTO.getDraftsid()!=0){
            HashMap<String, Integer> map = new HashMap<>();
            int i3 = draftsInfoMapper.removeDraft(draftsInfoDTO);
            List<DraftsInfoVO> draftsInfoVOS = draftsInfoMapper.selectImgsByDraftsid(draftsInfoDTO);
            for (int j = 0; j < draftsInfoVOS.size(); j++) {
                draftsInfoDTO.addurls(draftsInfoVOS.get(i).getUrl());
            }
            if (draftsInfoDTO.getUrls().size()>0){
                int i4 = draftsInfoMapper.insertNewsImgsByDrafts(draftsInfoDTO);
            }
        }
        if (i>0&&i1>0){
            return 1;
        }else {
            return 0;
        }
    }

}
