package com.sswh.platform.dao;

import com.sswh.platform.entity.PlatformUserEntity;

import java.util.List;

/**
 * Created by wangchengcheng on 2019/2/23
 */
public interface PlatformUserDao {
    /**
     * 注册用户
     * @param pfuser 后台用户实体
     * @return
     */
    public Integer registUser(PlatformUserEntity pfuser);

    /**
     * 批量插入用户的信息
     * @param pfusers 后台用户实体列表
     * @return
     */
    public Boolean registUsers(List<PlatformUserEntity> pfusers);

    /**
     * 根据用户的唯一键识别用户
     * @param userId
     * @return
     */
    public PlatformUserEntity findByIid(long userId);

    /**
     * 查询用户列表
     * @param iids
     * @return
     */
    public List<PlatformUserEntity> findByIids(List<Integer> iids);

    /**
     * 根据用户名获取用户
     * @param useName
     * @return
     */
    public PlatformUserEntity findByUserName(String useName);

    /**
     * 根据身份证号获取用户
     * @param idCard
     * @return
     */
    public PlatformUserEntity findByIdCard(String idCard);
}
