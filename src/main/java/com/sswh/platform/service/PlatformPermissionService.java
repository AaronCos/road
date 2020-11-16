package com.sswh.platform.service;

import com.sswh.entity.PlatformPermission;

import java.util.List;

/**
 * (PlatformPermission)表服务接口
 *
 * @author makejava
 * @since 2020-10-16 00:08:26
 */
public interface PlatformPermissionService {

    /**
     * 通过ID查询单条数据
     *
     * @param iid 主键
     * @return 实例对象
     */
    PlatformPermission queryById(Integer iid);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<PlatformPermission> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param platformPermission 实例对象
     * @return 实例对象
     */
    PlatformPermission insert(PlatformPermission platformPermission);

    /**
     * 修改数据
     *
     * @param platformPermission 实例对象
     * @return 实例对象
     */
    PlatformPermission update(PlatformPermission platformPermission);

    /**
     * 通过主键删除数据
     *
     * @param iid 主键
     * @return 是否成功
     */
    boolean deleteById(Integer iid);

}