package com.sswh.platform.service.impl;

import cn.hutool.core.util.NumberUtil;
import com.sswh.dao.RecruitDao;
import com.sswh.entity.RecruitEntity;
import com.sswh.platform.service.RecruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author nuanfeng
 * @date 2020/3/23 17:23
 */
@Service
public class RecruitServiceImpl implements RecruitService {

    @Autowired
    private RecruitDao recruitDao;

    @Override
    public List<RecruitEntity> findAllRecruit() {
        List<RecruitEntity> allRecruit = recruitDao.findAllRecruit();
        return allRecruit;
    }

    @Override
    public List<RecruitEntity> findByTitle(String title) {
        return recruitDao.findByTitle(title);
    }

    @Override
    public RecruitEntity findByIid(int iid) {
        return recruitDao.findByIid(iid);
    }

    @Override
    public List<RecruitEntity> findBySubject(int subjectBh, int pageshow) {
        return null;
    }

    @Override
    public int addRecruit(RecruitEntity recruitEntity) {
        int i = recruitDao.writeRecruit(recruitEntity);
        return i;
    }

    @Override
    public boolean deleteRecruit(String ids) {
        recruitDao.deleteRecruit(ids.split(","));
        return false;
    }

    @Override
    public boolean updateRecruit(RecruitEntity recruitEntity) {
        return false;
    }

    @Override
    public int changepageshow(String iid, String pageshow) {
        return recruitDao.changePageShow(NumberUtil.parseInt(pageshow), NumberUtil.parseInt(iid));
    }
}
