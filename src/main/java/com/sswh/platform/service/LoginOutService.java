package com.sswh.platform.service;


import com.sswh.entity.PlatformUser;

/**
 * Created by wangchengcheng on 2019/3/10
 */
public interface LoginOutService {

    PlatformUser findByUserName(String userName);

    /**
     * Created by wangchengcheng on 2019/9/13
     */
    class UserInfoService {
    }
}
