package com.sswh.platform.service;

import com.sswh.platform.entity.Users;

/**
 * Created by wangchengcheng on 2019/6/10
 */
public interface IUsersService {
    public boolean registUsers(Users users);
    public int deleteByUserId(int iid);
}
