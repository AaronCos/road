package com.sswh.platform.service.impl;

import com.sswh.platform.dao.PlatformUserDao;
import com.sswh.platform.entity.PlatformUser;
import com.sswh.platform.service.LoginOutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by wangchengcheng on 2019/3/10
 */
@Service
public class LoginOutServiceImpl implements LoginOutService {

    @Autowired
    PlatformUserDao userDao;

    @Override
    public PlatformUser findByUserName(String userName) {
        PlatformUser byUserName = userDao.findByUserName(userName);
        return byUserName;
    }
}
