package com.sswh.platform.service.impl;

import com.sswh.dao.PlatformPermissionDao;
import com.sswh.entity.PlatformPermission;
import com.sswh.platform.service.PlatformPermissionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (PlatformPermission)表服务实现类
 *
 * @author makejava
 * @since 2020-10-16 00:08:26
 */
@Service("platformPermissionService")
public class PlatformPermissionServiceImpl implements PlatformPermissionService {
    @Resource
    private PlatformPermissionDao platformPermissionDao;

    /**
     * 通过ID查询单条数据
     *
     * @param iid 主键
     * @return 实例对象
     */
    @Override
    public PlatformPermission queryById(Integer iid) {
        return this.platformPermissionDao.queryById(iid);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<PlatformPermission> queryAllByLimit(int offset, int limit) {
        return this.platformPermissionDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param platformPermission 实例对象
     * @return 实例对象
     */
    @Override
    public PlatformPermission insert(PlatformPermission platformPermission) {
        this.platformPermissionDao.insert(platformPermission);
        return platformPermission;
    }

    /**
     * 修改数据
     *
     * @param platformPermission 实例对象
     * @return 实例对象
     */
    @Override
    public PlatformPermission update(PlatformPermission platformPermission) {
        this.platformPermissionDao.update(platformPermission);
        return this.queryById(platformPermission.getIid());
    }

    /**
     * 通过主键删除数据
     *
     * @param iid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer iid) {
        return this.platformPermissionDao.deleteById(iid) > 0;
    }
}