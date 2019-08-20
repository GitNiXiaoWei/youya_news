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

    @Override
    public int updateDraft(DraftsInfoDTO draftsInfoDTO) {
        int i = draftsInfoMapper.updateDraft(draftsInfoDTO);
        int i1 = draftsInfoMapper.updateDraftsCategory(draftsInfoDTO);
        return i;
    }

}
