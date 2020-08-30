package com.sswh.dao;

import com.sswh.entity.PlatformGroup;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (PlatformGroup)表数据库访问层
 *
 * @author makejava
 * @since 2020-06-14 13:41:06
 */
public interface PlatformGroupDao {

    /**
     * 通过ID查询单条数据
     *
     * @param iid 主键
     * @return 实例对象
     */
    PlatformGroup queryById(Integer iid);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<PlatformGroup> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @param platformGroup 实体
     * @return 对象列表
     */
    List<PlatformGroup> queryAllByGroupName(@Param("offset") int offset, @Param("limit") int limit,PlatformGroup platformGroup );

    /**
     * 通过实体作为筛选条件查询
     *
     * @param platformGroup 实例对象
     * @return 对象列表
     */
    List<PlatformGroup> queryAll(PlatformGroup platformGroup);

    /**
     * 新增数据
     *
     * @param platformGroup 实例对象
     * @return 影响行数
     */
    int insert(PlatformGroup platformGroup);

    /**
     * 修改数据
     *
     * @param platformGroup 实例对象
     * @return 影响行数
     */
    int update(PlatformGroup platformGroup);

    /**
     * 通过主键删除数据
     *
     * @param iid 主键
     * @return 影响行数
     */
    int deleteById(Integer iid);

    /**
     * 通过主键列表删除数据
     *
     * @param iids 主键
     * @return 影响行数
     */
    int deleteByIds(List<Integer> iids);

}