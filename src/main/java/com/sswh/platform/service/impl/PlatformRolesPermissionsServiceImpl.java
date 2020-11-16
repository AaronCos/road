package com.sswh.platform.service.impl;

import com.sswh.dao.PlatformRolesPermissionsDao;
import com.sswh.entity.PlatformRolesPermissions;
import com.sswh.platform.service.PlatformRolesPermissionsService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (PlatformRolesPermissions)表服务实现类
 *
 * @author makejava
 * @since 2020-10-15 23:33:56
 */
@Service("platformRolesPermissionsService")
public class PlatformRolesPermissionsServiceImpl implements PlatformRolesPermissionsService {
    @Resource
    private PlatformRolesPermissionsDao platformRolesPermissionsDao;



    /**
     * 通过ID查询单条数据
     *
     * @param iid 主键
     * @return 实例对象
     */
    @Override
    public PlatformRolesPermissions queryById(Integer iid) {
        return this.platformRolesPermissionsDao.queryById(iid);
    }

    @Override
    public List<PlatformRolesPermissions> queryByRoleIds(List<Integer> roleIdList) {
        if (CollectionUtils.isEmpty(roleIdList)) {
            return null;
        }
        List<PlatformRolesPermissions> platformRolesPermissions = platformRolesPermissionsDao.queryByRoleIdList(roleIdList);
        return platformRolesPermissions;
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<PlatformRolesPermissions> queryAllByLimit(int offset, int limit) {
        return this.platformRolesPermissionsDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param platformRolesPermissions 实例对象
     * @return 实例对象
     */
    @Override
    public PlatformRolesPermissions insert(PlatformRolesPermissions platformRolesPermissions) {
        this.platformRolesPermissionsDao.insert(platformRolesPermissions);
        return platformRolesPermissions;
    }

    /**
     * 修改数据
     *
     * @param platformRolesPermissions 实例对象
     * @return 实例对象
     */
    @Override
    public PlatformRolesPermissions update(PlatformRolesPermissions platformRolesPermissions) {
        this.platformRolesPermissionsDao.update(platformRolesPermissions);
        return this.queryById(platformRolesPermissions.getIid());
    }

    /**
     * 通过主键删除数据
     *
     * @param iid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer iid) {
        return this.platformRolesPermissionsDao.deleteById(iid) > 0;
    }
}