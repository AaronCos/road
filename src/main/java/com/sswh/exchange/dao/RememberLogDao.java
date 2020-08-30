package com.sswh.exchange.dao;

import com.sswh.exchange.entity.RememberLog;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * (RememberLog)表数据库访问层
 *
 * @author makejava
 * @since 2020-08-06 19:42:02
 */
@Repository
public interface RememberLogDao {

    /**
     * 通过ID查询单条数据
     *
     * @param iid 主键
     * @return 实例对象
     */
    RememberLog queryById(Integer iid);

    /**
     * 通过rememberList表中的唯一键查询所有复习记录
     * @param rememberListIid remberlist 唯一键
     * @param state 处理状态
     * @param date  截止时间
     * @return
     */
    List<RememberLog> queryByRememberListIid(@Param("rememberListIid") Integer rememberListIid
            , @Param("state") Integer state, @Param("date") Date date);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<RememberLog> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param rememberLog 实例对象
     * @return 对象列表
     */
    List<RememberLog> queryAll(RememberLog rememberLog);

    /**
     * 新增数据
     *
     * @param rememberLog 实例对象
     * @return 影响行数
     */
    int insert(RememberLog rememberLog);

    /**
     * 修改数据
     *
     * @param rememberLog 实例对象
     * @return 影响行数
     */
    int update(RememberLog rememberLog);

    /**
     * 通过主键删除数据
     *
     * @param iid 主键
     * @return 影响行数
     */
    int deleteById(Integer iid);

}