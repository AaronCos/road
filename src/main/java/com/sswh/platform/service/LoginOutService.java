package com.sswh.platform.service;

import com.sswh.platform.entity.PlatformUser;

/**
 * Created by wangchengcheng on 2019/3/10
 */
public interface LoginOutService {

    PlatformUser findByUserName(String userName);
}