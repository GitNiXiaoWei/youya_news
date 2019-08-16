package service.impl;

import dao.DraftsInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.DraftsInfo;
import service.DraftsInfoService;

import java.util.List;

@Service
public class DraftsInfoServiceImpl implements DraftsInfoService {

    @Autowired
    DraftsInfoMapper draftsInfoMapper;

    public List<DraftsInfo> getAllDrafts(){
       return draftsInfoMapper.getAllDrafts();
    }

}
