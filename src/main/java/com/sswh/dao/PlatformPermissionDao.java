package com.sswh.dao;

import com.sswh.entity.PlatformPermission;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (PlatformPermission)表数据库访问层
 *
 * @author makejava
 * @since 2020-10-15 23:18:36
 */
public interface PlatformPermissionDao {

    /**
     * 通过ID查询单条数据
     *
     * @param iid 主键
     * @return 实例对象
     */
    PlatformPermission queryById(Integer iid);

    List<PlatformPermission> queryByIdList(List<Integer> rightIdList);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<PlatformPermission> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param platformPermission 实例对象
     * @return 对象列表
     */
    List<PlatformPermission> queryAll(PlatformPermission platformPermission);

    /**
     * 新增数据
     *
     * @param platformPermission 实例对象
     * @return 影响行数
     */
    int insert(PlatformPermission platformPermission);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<PlatformPermission> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<PlatformPermission> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<PlatformPermission> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<PlatformPermission> entities);

    /**
     * 修改数据
     *
     * @param platformPermission 实例对象
     * @return 影响行数
     */
    int update(PlatformPermission platformPermission);

    /**
     * 通过主键删除数据
     *
     * @param iid 主键
     * @return 影响行数
     */
    int deleteById(Integer iid);

}