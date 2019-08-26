package dao;

import dto.ReleaseSystemDTO;
import vo.ReleaseSystemVO;

import java.util.List;

public interface ReleaseSystemMapper {
    public List<ReleaseSystemVO> getAllNewsListsByCategoryid(int id);
    public List<ReleaseSystemVO> searchAllNews(ReleaseSystemDTO releaseSystemDTO);
    public ReleaseSystemVO getNewsDetailByNewsid(int id);
}
