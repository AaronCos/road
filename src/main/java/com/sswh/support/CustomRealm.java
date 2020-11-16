package com.sswh.support;

import cn.hutool.core.util.StrUtil;
import com.sswh.dao.PlatformUserDao;
import com.sswh.entity.PlatformUser;
import com.sswh.platform.service.PlatformUserService;
import com.sswh.platform.service.impl.RoleServiceImpl;
import org.apache.commons.collections.CollectionUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;

/**
 * Created by AaronCos on 2019/6/28
 */
public class CustomRealm extends AuthorizingRealm {


    @Resource
    PlatformUserDao platformUserDao;

    @Resource
    PlatformUserService platformUserService;

    @Resource
    RoleServiceImpl roleService;



    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        Subject subject = SecurityUtils.getSubject();
        PlatformUser platformUser = (PlatformUser) subject.getPrincipal();
        Integer iid = platformUser.getIid();
        List<Integer> roleIds = platformUserService.queryRoles(iid);
        Set<String> roleNameSet;
        if (CollectionUtils.isNotEmpty(roleIds)) {
            roleNameSet = roleService.queryRoleNameSet(roleIds);
            simpleAuthorizationInfo.addRoles(roleNameSet);
        }
        Set<String> rightNameSet = platformUserService.queryRightNameSet(iid);
        if (CollectionUtils.isNotEmpty(rightNameSet)) {
            simpleAuthorizationInfo.setStringPermissions(rightNameSet);
        }
        return simpleAuthorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String userName = (String) token.getPrincipal();
        PlatformUser user = getPasswordByUserName(userName);
        String password_salt = "";
        if (StrUtil.isEmpty(user.getPassword())) {
            return null;
        }
        if (user.getPasswordSalt() == null) {
            password_salt = "hello";
        }else{
            password_salt = user.getPasswordSalt();
        }
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(user, user.getPassword(), getName());
        simpleAuthenticationInfo.setCredentialsSalt(ByteSource.Util.bytes(password_salt));
        return simpleAuthenticationInfo;
    }

    private PlatformUser getPasswordByUserName(String userName) {
        return platformUserDao.findByUsername(userName);
    }
}
