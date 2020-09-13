package com.sswh.userpivot.service;

import com.sswh.userpivot.entity.WeuiUser;
import java.util.List;

/**
 * (WeuiUser)表服务接口
 *
 * @author makejava
 * @since 2020-08-17
 */
public interface WeuiUserService {

    /**
     * 通过ID查询单条数据
     *
     * @param iid 主键
     * @return 实例对象
     */
    WeuiUser queryById(Integer iid);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<WeuiUser> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param weuiUser 实例对象
     * @return 实例对象
     */
    WeuiUser insert(WeuiUser weuiUser);

    /**
     * 修改数据
     *
     * @param weuiUser 实例对象
     * @return 实例对象
     */
    WeuiUser update(WeuiUser weuiUser);

    /**
     * 通过主键删除数据
     *
     * @param iid 主键
     * @return 是否成功
     */
    boolean deleteById(Integer iid);

}