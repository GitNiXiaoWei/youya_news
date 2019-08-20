package service;

import pojo.DraftsInfo;

import java.util.List;

public interface DraftsInfoService {
    public List<DraftsInfo> getAllDrafts();
    public int removeDraft(DraftsInfo draftsInfo);
}
