package com.sswh.platform.service;

import com.sswh.entity.PlatformGroup;

import java.util.List;

/**
 * (PlatformGroup)表服务接口
 *
 * @author makejava
 * @since 2020-06-14 13:39:32
 */
public interface GroupService {

    /**
     * 通过ID查询单条数据
     *
     * @param iid 主键
     * @return 实例对象
     */
    PlatformGroup queryById(Integer iid);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<PlatformGroup> queryAllByLimit(int offset, int limit);

    /**
     * 查询通过标题
     *
     * @return 对象列表
     */
    List<PlatformGroup> queryAll(PlatformGroup group);

    /**
     * 新增数据
     *
     * @param platformGroup 实例对象
     * @return 实例对象
     */
    PlatformGroup insert(PlatformGroup platformGroup);

    /**
     * 修改数据
     *
     * @param platformGroup 实例对象
     * @return 实例对象
     */
    PlatformGroup update(PlatformGroup platformGroup);

    /**
     * 通过主键删除数据
     *
     * @param iid 主键
     * @return 是否成功
     */
    boolean deleteById(Integer iid);
    /**
     * 通过主键删除数据
     *
     * @param iids 主键
     * @return 是否成功
     */
    boolean deleteByIds(String iids);

    /**
     * 子级机构及其所有父机构列表
     * @param groupId
     * @return
     */
    List<Integer> queryGroupLevelList(Integer groupId, List<Integer> list);

}