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
     boolean registerUser(Users user);

    /**
     * 通过用户id删除用户
     * @param iid 用户的唯一键
     * @return 是否删除成功
     */
     int deleteByUserId(int iid);

    /**
     * 通过此用户名判断用户是否存在
     * @param userName 用户名
     * @return 发现该用户名的用户数量
     */
     int findByUserName(String userName);
}
