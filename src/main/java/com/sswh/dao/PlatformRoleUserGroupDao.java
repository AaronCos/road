package com.sswh.dao;

import com.sswh.entity.PlatformRoleUserGroup;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (PlatformRoleUserGroup)表数据库访问层
 *
 * @author AaronCos
 * @since 2020-10-15
 */
public interface PlatformRoleUserGroupDao {

    /**
     * 通过ID查询单条数据
     *
     * @param iid 主键
     * @return 实例对象
     */
    PlatformRoleUserGroup queryById(@Param("iid") Integer iid);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<PlatformRoleUserGroup> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param platformRoleUserGroup 实例对象
     * @return 对象列表
     */
    List<PlatformRoleUserGroup> queryAll(PlatformRoleUserGroup platformRoleUserGroup);

    /**
     * 新增数据
     *
     * @param platformRoleUserGroup 实例对象
     * @return 影响行数
     */
    int insert(PlatformRoleUserGroup platformRoleUserGroup);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<PlatformRoleUserGroup> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<PlatformRoleUserGroup> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<PlatformRoleUserGroup> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<PlatformRoleUserGroup> entities);

    /**
     * 修改数据
     *
     * @param platformRoleUserGroup 实例对象
     * @return 影响行数
     */
    int update(PlatformRoleUserGroup platformRoleUserGroup);

    /**
     * 通过主键删除数据
     *
     * @param iid 主键
     * @return 影响行数
     */
    int deleteById(Integer iid);

    /**
     * 查询组织角色关系实体列表查询
     * @param groupLevelId
     * @return
     */
    List<PlatformRoleUserGroup> queryByGroupId(@Param("groupid") Integer groupLevelId);

    /**
     * 用户-角色关系实体列表查询
     * @param userid
     * @return
     */
    List<PlatformRoleUserGroup> queryByUserId(@Param("userid") Integer userid);
}