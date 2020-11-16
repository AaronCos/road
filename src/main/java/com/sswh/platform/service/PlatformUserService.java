package com.sswh.platform.service;

import com.sswh.entity.PlatformUser;

import java.util.List;
import java.util.Set;

public interface PlatformUserService {

    /**
     * 查询后台用户实体
     * @param userId
     * @return
     */
    PlatformUser queryByUserId(Integer userId);
    /**
     * 查询用户所有的角色-通过用户的id
     * @param userId
     * @return
     */
    List<Integer> queryRoles(Integer userId);

    /**
     * 查询用户拥有的所有角色名称列表
     * @param userId
     * @return
     */
    Set<String> queryRoleNameSet(Integer userId);

    /**
     * 查询用户所有的权限-通过用户的id
     * @param userId
     * @return
     */
    List<Integer> queryRights(Integer userId);


    Set<String> queryRightNameSet(Integer userId);

}
