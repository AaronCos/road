package com.sswh.platform.service.impl;

import com.sswh.dao.IPlatformUserDao;
import com.sswh.entity.PlatformUser;
import com.sswh.platform.service.LoginOutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by wangchengcheng on 2019/3/10
 */
@Service
public class LoginOutServiceImpl implements LoginOutService {

    @Autowired
    IPlatformUserDao userDao;

    @Override
    public PlatformUser findByUserName(String userName) {
        PlatformUser byUserName = userDao.findByUsername(userName);
        return byUserName;
    }
}
