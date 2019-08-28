package service;

import dto.CommentInfoDTO;
import dto.ReleaseSystemDTO;
import vo.CommentVO;
import vo.ReleaseSystemVO;

import java.util.List;

public interface ReleaseSystemService {
    public List<ReleaseSystemVO> getAllNewsListsByCategoryid(int id);
    public List<ReleaseSystemVO> searchAllNews(ReleaseSystemDTO releaseSystemDTO);
    public ReleaseSystemVO getNewsDetailByNewsid(int id);
    public List<CommentVO> getAllCommentByNewsid(int id);
    public int insertComment(CommentInfoDTO commentInfoDTO);
    public int insertReply(CommentInfoDTO commentInfoDTO);

}
