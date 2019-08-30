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
import vo.ReplyVO;

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
        if (releaseSystemDTO.getCategoryname().equals("guoji")){
            releaseSystemDTO.setCategoryid(1);
        }else if (releaseSystemDTO.getCategoryname().equals("guonei")){
            releaseSystemDTO.setCategoryid(2);
        }else if (releaseSystemDTO.getCategoryname().equals("shishang")){
            releaseSystemDTO.setCategoryid(3);
        }else if (releaseSystemDTO.getCategoryname().equals("lvyou")){
            releaseSystemDTO.setCategoryid(4);
        }else if (releaseSystemDTO.getCategoryname().equals("youxi")){
            releaseSystemDTO.setCategoryid(5);
        }else if (releaseSystemDTO.getCategoryname().equals("jiaoyu")){
            releaseSystemDTO.setCategoryid(6);
        }else if (releaseSystemDTO.getCategoryname().equals("keji")){
            releaseSystemDTO.setCategoryid(7);
        }else if (releaseSystemDTO.getCategoryname().equals("qiche")){
            releaseSystemDTO.setCategoryid(8);
        }else if (releaseSystemDTO.getCategoryname().equals("yule")){
            releaseSystemDTO.setCategoryid(9);
        }else if (releaseSystemDTO.getCategoryname().equals("fangchan")){
            releaseSystemDTO.setCategoryid(10);
        }else if (releaseSystemDTO.getCategoryname().equals("caijing")){
            releaseSystemDTO.setCategoryid(11);
        }else if (releaseSystemDTO.getCategoryname().equals("tiyu")){
            releaseSystemDTO.setCategoryid(12);
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

    /**
     * 新增回复
     * @param commentInfoDTO
     * @return
     */
    @Override
    public int insertReply(CommentInfoDTO commentInfoDTO) {
        int i = commentInfoMapper.insertReply(commentInfoDTO);
        System.out.println("commentInfoDTO.getCommentid() = " + commentInfoDTO.getCommentid());
        int i1 = commentInfoMapper.insertTalksByNewsid(commentInfoDTO);
        if (i>0&&i1>0){
            return 1;
        }else return 0;
    }

    /**
     * 通过userid获取有关评论信息
     * @param id
     * @return
     */
    @Override
    public List<CommentVO> getCommentByUserid(int id) {
        return commentInfoMapper.getCommentByUserid(id);
    }

    /**
     * 通过userid获取被回复的信息
     * @param id
     * @return
     */
    @Override
    public List<ReplyVO> getReplyByUserid(int id) {
        return commentInfoMapper.getReplyByUserid(id);
    }

    /**
     * 通过userid获取最新的回复消息
     * @param id
     * @return
     */
    @Override
    public List<ReplyVO> getNewReply(int id) {
        return commentInfoMapper.getNewReply(id);
    }

    /**
     * 通过userid将查看过后的回复消息置为1
     * @param id
     * @return
     */
    @Override
    public int updateLookedNewReply(int id) {
        return commentInfoMapper.updateLookedNewReply(id);
    }
}
