package com.sswh.front.dao;

import com.sswh.front.entity.FrontUserEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by wangchengcheng on 2019/6/26
 */
@Repository(value = "frontUserDao")
public interface IFrontUserDao {

    /**
     *
     * @param loginname 前台用户登录名称
     * @return 前台用户实体
     */
    FrontUserEntity findByLoginName(String loginname);

    /**
     * 查询所有的前台用户
     * @return 前台用户实体列表
     */
    List<FrontUserEntity> findAllFrontUser();

    /**
     * 通过登录名，获取密码
     * @param userName
     * @return
     */
    String getPasswordByLoginame(String userName);

    /**
     * 通过登录名，获取盐值
     * @param userName
     * @return
     */
    String getPasswordSaltByLoginname(String userName);

    /**
     * 注册前台用户
     * @param user 必须包含登录名
     * @return
     */
    Integer registUser(FrontUserEntity user);

    /**
     * 通过唯一键删除前台用户
     * @param iid
     * @return
     */
    int deleteByUserId(int iid);

    /**
     * 通过iid 修改前台用户信息
     * @param user
     * @return
     */
    int updateByUserIid(FrontUserEntity user);

    /**
     * 查询相同姓名的人数
     * @param loginname
     * @return 相同姓名的人数
     */
    Integer findCountByLoginname(String loginname);

    /**
     * 修改前台用户信息
     * @param user 修改完的前台用户实体
     * @return 修改成功>0
     */
    int updateByLoginname(FrontUserEntity user);


    void updateStatusOrIsStudent(@Param("iid") String iid, @Param("name")String name, @Param("state")String state);

    List<FrontUserEntity> findFrontUsers(@Param("username")String username,@Param("start") String start,@Param("end") String end,@Param("page") int page,@Param("limit") int limit);

    int findFrontUsersCount(@Param("username")String username,@Param("start") String start,@Param("end") String end);

    boolean deleteFrontUser(@Param("ids")String ids);
}
