package service.impl;

import dao.CommentInfoMapper;
import dao.ReleaseSystemMapper;
import dto.CommentInfoDTO;
import dto.ReleaseSystemDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import service.ReleaseSystemService;
import vo.CommentVO;
import vo.ReleaseSystemVO;

import java.util.List;
@Service
public class ReleaseSystemServiceImpl implements ReleaseSystemService {

    @Autowired
    ReleaseSystemMapper releaseSystemMapper;
    @Autowired
    CommentInfoMapper commentInfoMapper;

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

    @Override
    public List<CommentVO> getAllCommentByNewsid(int id) {
        return commentInfoMapper.getAllCommentByNewsid(id);
    }

    /**
     * 新增评论
     * @param commentInfoDTO
     * @return
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int insertComment(CommentInfoDTO commentInfoDTO) {
        int i = commentInfoMapper.insertComment(commentInfoDTO);
        int i1 = commentInfoMapper.insertTalksByNewsid(commentInfoDTO);
        if (i>0&&i1>0){
            return 1;
        }else return 0;
    }
}
