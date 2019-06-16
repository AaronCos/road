package com.sswh.platform.dao;

import com.sswh.platform.entity.PlatformUser;

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
    public Integer registUser(PlatformUser pfuser);

    /**
     * 批量插入用户的信息
     * @param pfusers 后台用户实体列表
     * @return
     */
    public Boolean registUsers(List<PlatformUser> pfusers);

    /**
     * 根据用户的唯一键识别用户
     * @param userId
     * @return
     */
    public PlatformUser findByIid(long userId);

    /**
     * 查询用户列表
     * @param iids
     * @return
     */
    public List<PlatformUser> findByIids(List<Integer> iids);

    /**
     * 根据用户名获取用户
     * @param userName
     * @return
     */
    public PlatformUser findByUserName(String userName);

    /**
     * 根据身份证号获取用户
     * @param idCard
     * @return
     */
    public PlatformUser findByIdCard(String idCard);
}
