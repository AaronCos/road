package com.sswh.exchange.service;

import com.sswh.exchange.entity.RememberList;
import java.util.List;

/**
 * (RememberList)表服务接口
 *
 * @author makejava
 * @since 2020-08-05 16:18:50
 */
public interface RememberListService {


    /**
     *
     * @param rememberList
     * @return 成功插入的数量
     */
    public int abhsInsert(RememberList rememberList);


    /**
     * 通过ID查询单条数据
     *
     * @param iid 主键
     * @return 实例对象
     */
    RememberList queryById(Integer iid);

    /**
     * 通过用户id查询多条基础
     * @return
     */
    List<RememberList> queryByUserId(Integer userId);


    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<RememberList> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param rememberList 实例对象
     * @return 实例对象
     */
    RememberList insert(RememberList rememberList);

    /**
     * 修改数据
     *
     * @param rememberList 实例对象
     * @return 实例对象
     */
    RememberList update(RememberList rememberList);

    /**
     * 通过主键删除数据
     *
     * @param iid 主键
     * @return 是否成功
     */
    boolean deleteById(Integer iid);

}