package com.sswh.support;

import cn.hutool.core.util.StrUtil;
import com.sswh.dao.IPlatformUserDao;
import com.sswh.entity.PlatformUser;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by wangchengcheng on 2019/6/28
 */
public class CustomRealm extends AuthorizingRealm {
    @Autowired
    IPlatformUserDao platformUserDao;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String userName = (String) token.getPrincipal();
        PlatformUser user = getPasswordByUserName(userName);
        String password_salt = "";
        if (StrUtil.isEmpty(user.getPassword())) {
            return null;
        }
        if (user.getPassword_salt() == null) {
            password_salt = "hello";
        }else{
            password_salt = user.getPassword_salt();
        }
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(user.getUsername(), user.getPassword(), getName());
        simpleAuthenticationInfo.setCredentialsSalt(ByteSource.Util.bytes(password_salt));
        return simpleAuthenticationInfo;
    }

    private PlatformUser getPasswordByUserName(String userName) {
        return platformUserDao.findByUsername(userName);
    }
}
