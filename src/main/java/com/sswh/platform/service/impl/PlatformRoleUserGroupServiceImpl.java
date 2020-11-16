package com.sswh.platform.service.impl;

import com.sswh.dao.PlatformRoleUserGroupDao;
import com.sswh.entity.PlatformRoleUserGroup;
import com.sswh.platform.service.PlatformRoleUserGroupService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * (PlatformRoleUserGroup)表服务实现类
 *
 * @author AaronCos
 * @since 2020-10-15
 */
@Service("platformRoleUserGroupService")
public class PlatformRoleUserGroupServiceImpl implements PlatformRoleUserGroupService {

    @Resource
    private PlatformRoleUserGroupDao platformRoleUserGroupDao;

    /**
     * 通过ID查询单条数据
     *
     * @return 实例对象
     */
    @Override
    public PlatformRoleUserGroup queryById() {
        int iid = 0;
        return this.platformRoleUserGroupDao.queryById(iid);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<PlatformRoleUserGroup> queryAllByLimit(int offset, int limit) {
        return this.platformRoleUserGroupDao.queryAllByLimit(offset, limit);
    }

    @Override
    public boolean addRoleAndGroupRelation(Integer groupId, Integer roleId) {
        PlatformRoleUserGroup platformRoleUserGroup = new PlatformRoleUserGroup();
        platformRoleUserGroup.setGroupid(groupId);
        platformRoleUserGroup.setRoleid(roleId);
        int insert = this.platformRoleUserGroupDao.insert(platformRoleUserGroup);
        return insert >0 ? true : false;
    }

    @Override
    public boolean addRoleAndUserRelation(Integer userId, Integer roleId) {
        PlatformRoleUserGroup platformRoleUserGroup = new PlatformRoleUserGroup();
        platformRoleUserGroup.setUserid(userId);
        platformRoleUserGroup.setRoleid(roleId);
        int insert = this.platformRoleUserGroupDao.insert(platformRoleUserGroup);
        return insert >0 ? true : false;
    }

    @Override
    public boolean removeGroupsByRoleId(Integer roleId, List<Integer> groupIdList) {
        return false;
    }

    @Override
    public boolean removeUsersByRoleId(Integer roleId, List<Integer> userIdList) {
        return false;
    }

    @Override
    public boolean removeRoleIdGroupUserRelation(Integer roleId) {
        return false;
    }

    /**
     * 修改数据
     *
     * @param platformRoleUserGroup 实例对象
     * @return 实例对象
     */
    @Override
    public PlatformRoleUserGroup update(PlatformRoleUserGroup platformRoleUserGroup) {
        this.platformRoleUserGroupDao.update(platformRoleUserGroup);
        return this.queryById();
    }

    /**
     * 通过主键删除数据
     *
     * @return 是否成功
     */
    @Override
    public boolean deleteById() {
        int iid = 0;
        return this.platformRoleUserGroupDao.deleteById(iid) > 0;
    }

    @Override
    public List<Integer> queryRoleIdsByGroupLevelId(Integer groupLevelId) {
        List<Integer> roleIdList = new ArrayList<>();
        List<PlatformRoleUserGroup> groupRoles = platformRoleUserGroupDao.queryByGroupId(groupLevelId);
        if (CollectionUtils.isNotEmpty(groupRoles)) {
            for (PlatformRoleUserGroup groupRole : groupRoles) {
                roleIdList.add(groupRole.getRoleid());
            }
        }
        return roleIdList;
    }

    @Override
    public List<Integer> queryRoleIdListByUserId(Integer userId) {
        List<Integer> roleIdSet = new ArrayList<>();
        List<PlatformRoleUserGroup> listPlatformRoleUserGroupByUserId = platformRoleUserGroupDao.queryByUserId(userId);
        if (CollectionUtils.isNotEmpty(listPlatformRoleUserGroupByUserId)) {
            for (PlatformRoleUserGroup platformRoleUserGroup : listPlatformRoleUserGroupByUserId) {
                roleIdSet.add(platformRoleUserGroup.getRoleid());
            }
        }
        return roleIdSet;
    }
}