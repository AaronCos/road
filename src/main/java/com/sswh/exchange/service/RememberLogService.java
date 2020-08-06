package com.sswh.exchange.service;

import com.sswh.exchange.entity.RememberLog;

import java.util.List;

/**
 * (RememberLog)表服务接口
 *
 * @author makejava
 * @since 2020-08-06 10:42:04
 */
public interface RememberLogService {

    /**
     * 通过ID查询单条数据
     *
     * @param iid 主键
     * @return 实例对象
     */
    RememberLog queryById(Integer iid);

    /**
     * 查询所有已过期的记录
     * @param rememberListIid
     * @return
     */
    List<RememberLog> queryByRememberListIid(Integer rememberListIid);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<RememberLog> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param rememberLog 实例对象
     * @return 实例对象
     */
    RememberLog insert(RememberLog rememberLog);

    /**
     * 修改数据
     *
     * @param rememberLog 实例对象
     * @return 实例对象
     */
    RememberLog update(RememberLog rememberLog);

    /**
     * 通过主键删除数据
     *
     * @param iid 主键
     * @return 是否成功
     */
    boolean deleteById(Integer iid);

}