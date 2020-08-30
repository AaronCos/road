package com.sswh.platform.service;


import com.sswh.entity.PlatformUser;

import java.util.List;

/**
 * Created by nuanfeng on 2019/3/10
 */
public interface LoginOutService {

    /**
     * 查找后台所有用户信息
     * @return
     */
    public List<PlatformUser> findAllUser();

    PlatformUser findByUserName(String userName);

    /**
     * Created by wangchengcheng on 2019/9/13
     */

}
