package com.sswh.platform.service.impl;

import com.sswh.dao.IPlatformUserDao;
import com.sswh.entity.PlatformUser;
import com.sswh.platform.service.AbstractPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author nuanfeng
 * @date 2020/6/22 14:32
 */
@Service
public class PlatformUserServiceImpl extends AbstractPageService<PlatformUser, IPlatformUserDao> {


    @Autowired
    public PlatformUserServiceImpl(IPlatformUserDao tempDao) {
        pageDao = tempDao;
    }

    @Override
    public List<PlatformUser> findAll() {
        List<PlatformUser> allRoles = pageDao.findAllPlatformUser();
        return allRoles;
    }

    @Override
    public List<PlatformUser> findByTitle(String title) {
        List<PlatformUser> allPlatformUser = pageDao.findAllByTitle(title);
        return allPlatformUser;
    }

    @Override
    public PlatformUser findByIid(int iid) {
        PlatformUser user = pageDao.findByIid(iid);
        return user;
    }

    @Override
    public int addByEntity(PlatformUser entity) {
        Integer integer = pageDao.registUser(entity);
        return integer;
    }

    @Override
    public boolean deleteByIds(String ids) {

        return false;
    }

    @Override
    public boolean updateByEntity(PlatformUser entity) {
        return false;
    }


}
