package dao;

import dto.CommentInfoDTO;
import vo.CommentVO;

import java.util.List;

public interface CommentInfoMapper {
    public List<CommentVO> getAllCommentByNewsid(int id);
    public int insertComment(CommentInfoDTO commentInfoDTO);
    public int insertTalksByNewsid(CommentInfoDTO commentInfoDTO);
    public int insertReply(CommentInfoDTO commentInfoDTO);
}
