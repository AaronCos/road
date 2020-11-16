package com.sswh.dao;

import com.sswh.entity.PlatformRolesPermissions;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (PlatformRolesPermissions)表数据库访问层
 *
 * @author makejava
 * @since 2020-10-15 23:32:36
 */
public interface PlatformRolesPermissionsDao {

    /**
     * 通过ID查询单条数据
     *
     * @param iid 主键
     * @return 实例对象
     */
    PlatformRolesPermissions queryById(Integer iid);

    /**
     * 通过角色id列表查询角色实体关系列表
     * @param roleId
     * @return
     */
    List<PlatformRolesPermissions> queryByRoleId(Integer roleId);

    /**
     * 通过角色id列表查询角色实体关系列表
     * @param roleIdList
     * @return
     */

    List<PlatformRolesPermissions> queryByRoleIdList(@Param("roleIdList") List<Integer> roleIdList);



    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<PlatformRolesPermissions> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param platformRolesPermissions 实例对象
     * @return 对象列表
     */
    List<PlatformRolesPermissions> queryAll(PlatformRolesPermissions platformRolesPermissions);

    /**
     * 新增数据
     *
     * @param platformRolesPermissions 实例对象
     * @return 影响行数
     */
    int insert(PlatformRolesPermissions platformRolesPermissions);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<PlatformRolesPermissions> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<PlatformRolesPermissions> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<PlatformRolesPermissions> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<PlatformRolesPermissions> entities);

    /**
     * 修改数据
     *
     * @param platformRolesPermissions 实例对象
     * @return 影响行数
     */
    int update(PlatformRolesPermissions platformRolesPermissions);

    /**
     * 通过主键删除数据
     *
     * @param iid 主键
     * @return 影响行数
     */
    int deleteById(Integer iid);

}