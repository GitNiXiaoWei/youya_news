package dao;

import dto.CommentInfoDTO;
import vo.CommentVO;
import vo.ReplyVO;

import java.util.List;

public interface CommentInfoMapper {
    public List<CommentVO> getAllCommentByNewsid(int id);
    public int insertComment(CommentInfoDTO commentInfoDTO);
    public int insertTalksByNewsid(CommentInfoDTO commentInfoDTO);
    public int insertReply(CommentInfoDTO commentInfoDTO);
    public List<CommentVO> getCommentByUserid(int id);
    public List<ReplyVO> getReplyByUserid(int id);
    public List<ReplyVO> getNewReply(int id);
    public int updateLookedNewReply(int id);
}
