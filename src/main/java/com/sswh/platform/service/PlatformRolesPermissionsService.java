package com.sswh.platform.service;

import com.sswh.entity.PlatformRolesPermissions;

import java.util.List;

/**
 * (PlatformRolesPermissions)表服务接口
 *
 * @author makejava
 * @since 2020-10-15 23:33:56
 */
public interface PlatformRolesPermissionsService {

    /**
     * 通过ID查询单条数据
     *
     * @param iid 主键
     * @return 实例对象
     */
    PlatformRolesPermissions queryById(Integer iid);

    List<PlatformRolesPermissions> queryByRoleIds(List<Integer> roleIdList);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<PlatformRolesPermissions> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param platformRolesPermissions 实例对象
     * @return 实例对象
     */
    PlatformRolesPermissions insert(PlatformRolesPermissions platformRolesPermissions);

    /**
     * 修改数据
     *
     * @param platformRolesPermissions 实例对象
     * @return 实例对象
     */
    PlatformRolesPermissions update(PlatformRolesPermissions platformRolesPermissions);

    /**
     * 通过主键删除数据
     *
     * @param iid 主键
     * @return 是否成功
     */
    boolean deleteById(Integer iid);

}