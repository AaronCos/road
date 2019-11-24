package com.sswh.dao;


import com.sswh.entity.PlatformUser;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by wangchengcheng on 2019/2/23N
 */
@Repository(value = "iPlatformUserDao")
 public interface IPlatformUserDao {
    /**
     * 注册用户
     * @param pfuser 后台用户实体
     * @return
     */
    Integer registUser(PlatformUser pfuser);

    /**
     * 批量插入用户的信息
     * @param pfusers 后台用户实体列表
     * @return
     */
     Boolean registUsers(List<PlatformUser> pfusers);

    /**
     * 根据用户的唯一键识别用户
     * @param userId
     * @return
     */
     PlatformUser findByIid(long userId);

    /**
     * 查询用户列表
     * @param iids
     * @return
     */
     List<PlatformUser> findByIids(List<Integer> iids);

    /**
     * 根据用户名获取用户
     * @param userName
     * @return
     */
     PlatformUser findByUsername(String userName);

    /**
     * 返回该用户名下的账户数量
     * @param userName
     * @return
     */
     Integer findCountByUsername(String userName);

    /**
     * 根据身份证号获取用户
     * @param idCard
     * @return
     */
     PlatformUser findByIdCard(String idCard);
}
