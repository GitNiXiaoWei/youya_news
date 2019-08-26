package service.impl;

import dao.ReleaseSystemMapper;
import dto.ReleaseSystemDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.ReleaseSystemService;
import vo.ReleaseSystemVO;

import java.util.List;
@Service
public class ReleaseSystemServiceImpl implements ReleaseSystemService {

    @Autowired
    ReleaseSystemMapper releaseSystemMapper;
    @Override
    public List<ReleaseSystemVO> getAllNewsListsByCategoryid(int id) {

        return releaseSystemMapper.getAllNewsListsByCategoryid(id);
    }

    @Override
    public List<ReleaseSystemVO> searchAllNews(ReleaseSystemDTO releaseSystemDTO) {
        if (releaseSystemDTO.getCategoryname().equals("guonei")){
            releaseSystemDTO.setCategoryid(2);
        }
        return releaseSystemMapper.searchAllNews(releaseSystemDTO);
    }

    @Override
    public ReleaseSystemVO getNewsDetailByNewsid(int id) {
        return releaseSystemMapper.getNewsDetailByNewsid(id);
    }
}
