package com.sswh.platform.dao;

import com.sswh.platform.entity.Users;

/**
 * Created by wangchengcheng on 2019/6/10
 */
public interface IUsersDao {
    /**
     * 注册用户
     * @return
     */
    public boolean registerUser(Users user);

    /**
     * 通过用户id删除用户
     * @param iid
     * @return
     */
    public int deleteByUserId(int iid);
}
