package com.sswh.platform.service;

import com.sswh.platform.entity.Users;

/**
 * Created by wangchengcheng on 2019/6/10
 */
public interface IUsersService {
    /**
     * 注册用户并给密码加密
     * @param users 前台用户实体
     * @return true成功否则失败
     */
    public boolean registUsers(Users users);

    /**
     * 删除用户id
     * @param iid 用户iid
     * @return
     */
    public int deleteByUserId(int iid);

    /**
     * 查找库中用户是否存在
     * @param userName 用户名称
     * @return 用户数量
     */
    public int findByUserName(String userName);
}
