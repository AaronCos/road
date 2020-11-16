package com.sswh.dao;

import com.sswh.entity.PlatformRoles;

import java.util.List;

/**
 * @author nuanfeng
 * @date 2020/3/22 22:31
 */
public interface PlatformRolesDao {

    /**
     * 编写角色信息
     * @param role 角色实体
     * @return
     */
    int writeRole(PlatformRoles role);

    List<PlatformRoles> findAllRoles();

    /**
     * 角色id列表
     * @param idList
     * @return
     */
    List<PlatformRoles> findByIdList(List<Integer> idList);

    /**
     * 通过招聘标题获取招聘实体信息
     * @param title 标题
     * @return
     */
//    List<PlatformRoles> findByTitle(String title);

    /**
     * 通过科目代号获取招聘信息实体
     * @param subjectBh 编号
     * @return
     */
//    PlatformRoles findBySubjectBh(int subjectBh);

    /**
     * 修改展示状态
     * @param pageshow 是否展示
     * @param iid 招聘信息id
     * @return
     */
//    int changePageShow(@Param("pageshow") int pageshow, @Param("iid") int iid);



//    void deleteRoles(String[] ids);

}
