package com.sswh.front.dao;

import com.sswh.front.entity.FrontUserEntity;

/**
 * Created by wangchengcheng on 2019/6/26
 */
public interface IFrontUserDao {
    String getPasswordByUserName(String userName);
    String getPasswordSaltByUserName(String userName);
    int registerUser(FrontUserEntity frontUserEntity);
    int deleteByUserId(int iid);
}
