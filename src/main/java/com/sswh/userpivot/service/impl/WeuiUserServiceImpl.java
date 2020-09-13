package com.sswh.userpivot.service.impl;

import com.sswh.userpivot.entity.WeuiUser;
import com.sswh.userpivot.dao.WeuiUserDao;
import com.sswh.userpivot.service.WeuiUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (WeuiUser)表服务实现类
 *
 * @author makejava
 * @since 2020-08-17
 */
@Service("weuiUserService")
public class WeuiUserServiceImpl implements WeuiUserService {
    @Resource
    private WeuiUserDao weuiUserDao;

    /**
     * 通过ID查询单条数据
     *
     * @param iid 主键
     * @return 实例对象
     */
    @Override
    public WeuiUser queryById(Integer iid) {
        return this.weuiUserDao.queryById(iid);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<WeuiUser> queryAllByLimit(int offset, int limit) {
        return this.weuiUserDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param weuiUser 实例对象
     * @return 实例对象
     */
    @Override
    public WeuiUser insert(WeuiUser weuiUser) {
        this.weuiUserDao.insert(weuiUser);
        return weuiUser;
    }

    /**
     * 修改数据
     *
     * @param weuiUser 实例对象
     * @return 实例对象
     */
    @Override
    public WeuiUser update(WeuiUser weuiUser) {
        this.weuiUserDao.update(weuiUser);
        return this.queryById(weuiUser.getIid());
    }

    /**
     * 通过主键删除数据
     *
     * @param iid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer iid) {
        return this.weuiUserDao.deleteById(iid) > 0;
    }
}