package com.sswh.platform.service;

import com.sswh.entity.PlatformRoleUserGroup;

import java.util.List;

/**
 * (PlatformRoleUserGroup)表服务接口
 *
 * @author AaronCos
 * @since 2020-10-15
 */
public interface PlatformRoleUserGroupService {

    /**
     * 通过ID查询单条数据
     *
     * @return 实例对象
     */
    PlatformRoleUserGroup queryById();

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<PlatformRoleUserGroup> queryAllByLimit(int offset, int limit);

    /**
     * 添加角色-组织对应关系
     * @param groupId 组织id
     * @param roleId  角色id
     * @return
     */
    boolean addRoleAndGroupRelation(Integer groupId, Integer roleId);

    /**
     * 添加角色-用户对应关系
     * @param userId  用户id
     * @param roleId  角色id
     * @return
     */
    boolean addRoleAndUserRelation(Integer userId, Integer roleId);


    /**
     * 删除组织对应的角色成员关系
     *
     * @param roleId
     *            角色ID
     * @param groupIdList
     *            组织ID 集合
     * @return true - 成功<br/>
     *         false - 失败
     */
    public boolean removeGroupsByRoleId(Integer roleId, List<Integer> groupIdList);

    /**
     * 删除用户对应的角色成员关系
     *
     * @param roleId
     *            角色ID
     * @param userIdList
     *            组织ID 集合
     * @return true - 成功<br/>
     *         false - 失败
     */
    boolean removeUsersByRoleId(Integer roleId, List<Integer> userIdList);

    /**
     * 删除角色对应的组织用户关系
     * @param roleid
     * @return
     */
    boolean removeRoleIdGroupUserRelation(Integer roleid);

    /**
     * 修改数据
     *
     * @param platformRoleUserGroup 实例对象
     * @return 实例对象
     */
    PlatformRoleUserGroup update(PlatformRoleUserGroup platformRoleUserGroup);

    /**
     * 通过主键删除数据
     * @return 是否成功
     */
    boolean deleteById();

    /**
     * 根据组织id获取角色id的列表
     * @param groupLevelId
     * @return
     */
    List<Integer> queryRoleIdsByGroupLevelId(Integer groupLevelId);

    /**
     * 根据用户id获取角色id的列表
     * @param userId 表中userId字段
     * @return
     */
    List<Integer> queryRoleIdListByUserId(Integer userId);
}