package com.sswh.exchange.dao;

import com.sswh.exchange.entity.RememberList;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (RememberList)表数据库访问层
 *
 * @author makejava
 * @since 2020-08-05 19:18:46
 */
public interface RememberListDao {

    /**
     * 通过ID查询单条数据
     *
     * @param iid 主键
     * @return 实例对象
     */
    RememberList queryById(Integer iid);

    List<RememberList> queryByUserId(@Param("userId") Integer userId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<RememberList> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param rememberList 实例对象
     * @return 对象列表
     */
    List<RememberList> queryAll(RememberList rememberList);

    /**
     * 新增数据
     *
     * @param rememberList 实例对象
     * @return 影响行数
     */
    int insert(RememberList rememberList);

    /**
     * 修改数据
     *
     * @param rememberList 实例对象
     * @return 影响行数
     */
    int update(RememberList rememberList);

    /**
     * 通过主键删除数据
     *
     * @param iid 主键
     * @return 影响行数
     */
    int deleteById(Integer iid);

}