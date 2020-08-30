package com.sswh.dao;


import com.sswh.entity.PlatformUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author nuanfeng
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
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<PlatformUser> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);

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

    /**
     * 查询用户列表
     * @return
     */
     List<PlatformUser> findAllPlatformUser();

    /**
     * 标题
     * @return
     */
    List<PlatformUser> findAllByTitle(String title);

    /**
     * 根据ids删除用户
     * @param ids
     * @return
     */
    int deleteByIds(List<Integer> ids);
}
