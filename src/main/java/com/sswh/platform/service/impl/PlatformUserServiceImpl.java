package com.sswh.platform.service.impl;

import com.sswh.dao.PlatformPermissionDao;
import com.sswh.dao.PlatformUserDao;
import com.sswh.entity.PlatformPermission;
import com.sswh.entity.PlatformRoleUserGroup;
import com.sswh.entity.PlatformRolesPermissions;
import com.sswh.entity.PlatformUser;
import com.sswh.platform.service.*;
import com.sswh.util.NumberUtil;
import com.sswh.utils.core.StrUtil;
import org.apache.commons.collections.CollectionUtils;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author nuanfeng
 * @date 2020/6/22
 */
@Service
public class PlatformUserServiceImpl extends AbstractPageService<PlatformUser, PlatformUserDao> implements PlatformUserService {


    @Autowired
    public PlatformUserServiceImpl(PlatformUserDao tempDao) {
        pageDao = tempDao;
    }

    @Resource
    public PlatformRoleUserGroupService platformRoleUserGroupService;

    @Resource
    public PlatformRolesPermissionsService platformRolesPermissionsService;

    @Resource
    public PlatformPermissionDao platformPermissionDao;

    @Resource
    public GroupService groupService;

    @Override
    public List<PlatformUser> findAll() {
        List<PlatformUser> allRoles = pageDao.findAllPlatformUser();
        return allRoles;
    }

    @Override
    public List<PlatformUser> findByTitle(String title) {
        List<PlatformUser> allPlatformUser = pageDao.findAllByTitle(title);
        return allPlatformUser;
    }

    @Override
    public PlatformUser findByIid(int iid) {
        PlatformUser user = pageDao.findByIid(iid);
        return user;
    }

    @Override
    public int addByEntity(PlatformUser user) {
        String message = "";
        //1. 判断此用户名称是否已经存在
        Integer count = pageDao.findCountByUsername(user.getUsername());
        if (count > 0) {
            message = "当前用户名已存在，请重新输入";
            return 0;
        }
        String password_salt = StrUtil.generateUuid();

        user.setPasswordSalt(password_salt);
        user.setPassword(new Md5Hash(user.getPassword(), password_salt).toString());
        Integer integer = pageDao.registUser(user);
        return integer;
    }

    /**
     * 删除后台用户
     * @param ids iid字符串
     * @return 是否删除成功
     */
    @Override
    public boolean deleteByIds(String ids) {
        Set<Integer> integers = new HashSet<>();
        int i = 0;
        if (!ids.isEmpty()) {
            String[] split =  ids.split("\\,");
            if (split != null && split.length>0) {
                for (String s : split) {
                    integers.add(NumberUtil.getInt(s));
                }
            }
            List<Integer> list = new ArrayList<>(integers);
            i = pageDao.deleteByIds(list);
        }
        return i > 0;
    }

    @Override
    public boolean updateByEntity(PlatformUser entity) {
        return false;
    }


    @Override
    public PlatformUser queryByUserId(Integer userId) {


        return null;
    }

    @Override
    public List<Integer> queryRoles(Integer userId) {

        List<Integer> roleList = new ArrayList<>();
        int userid = NumberUtil.getInt(userId);
        if (userid == 0) {
            return null;
        }

        PlatformUser user = pageDao.findByIid(userId);
        if (user == null) {
            return null;
        }
        PlatformRoleUserGroup platformRoleUserGroup = new PlatformRoleUserGroup();
        HashSet<Integer> roleIdSet = new HashSet<>();

        //获取用户角色列表通过用户id绑定的
        List<Integer> roleIdListByUserId = platformRoleUserGroupService.queryRoleIdListByUserId(userId);
        roleIdSet.addAll(roleIdListByUserId);
        //获取该用户所在的树形组织id列表-通过用户所在直接组织id
        Integer groupIid = user.getGroupIid();
        List<Integer> groupLevelLists = new ArrayList<>();
        if (NumberUtil.getInt(groupIid) != 0) {
            groupLevelLists = groupService.queryGroupLevelList(groupIid, groupLevelLists);
        }

        //获取用户角色列表通过遍历所有组织的角色并相加去重
        if (CollectionUtils.isNotEmpty(groupLevelLists)) {
            for (Integer groupLevelId : groupLevelLists) {
                List<Integer> RoleIdListByGroupId = platformRoleUserGroupService.queryRoleIdsByGroupLevelId(groupLevelId);
                if (CollectionUtils.isNotEmpty(RoleIdListByGroupId)) {
                    for (Integer roleId : RoleIdListByGroupId) {
                        roleIdSet.add(roleId);
                    }
                }
            }
        }
        roleList.addAll(roleIdSet);
        return roleList;
    }

    @Override
    public Set<String> queryRoleNameSet(Integer userId) {
        List<Integer> roleIdList = queryRoles(userId);

        return null;
    }

    @Override
    public List<Integer> queryRights(Integer userId) {
        List<Integer> roleIdList = queryRoles(userId);
        List<Integer> rightIds = new ArrayList<>();
        List<PlatformRolesPermissions> platformRolesPermissions = platformRolesPermissionsService.queryByRoleIds(roleIdList);
        if (CollectionUtils.isNotEmpty(platformRolesPermissions) && platformRolesPermissions.size()>0) {
            for (PlatformRolesPermissions platformRolesPermission : platformRolesPermissions) {
                rightIds.add(platformRolesPermission.getPermissionid());
            }
        }
        return rightIds;
    }

    @Override
    public Set<String> queryRightNameSet(Integer userId) {
        List<Integer> rights = queryRights(userId);
        if (CollectionUtils.isEmpty(rights)) {
            return null;
        }
        Set<String> rightNameSet = new HashSet<>();
        List<PlatformPermission> platformPermissions = platformPermissionDao.queryByIdList(rights);
        for (PlatformPermission platformPermission : platformPermissions) {
            rightNameSet.add(platformPermission.getName());
        }
        return rightNameSet;
    }


}
