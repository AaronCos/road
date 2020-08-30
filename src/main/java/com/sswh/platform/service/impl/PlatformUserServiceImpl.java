package com.sswh.platform.service.impl;

import cn.hutool.core.util.NumberUtil;
import com.sswh.dao.IPlatformUserDao;
import com.sswh.entity.PlatformUser;
import com.sswh.platform.service.AbstractPageService;
import com.sswh.utils.core.StrUtil;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author nuanfeng
 * @date 2020/6/22 14:32
 */
@Service
public class PlatformUserServiceImpl extends AbstractPageService<PlatformUser, IPlatformUserDao> {


    @Autowired
    public PlatformUserServiceImpl(IPlatformUserDao tempDao) {
        pageDao = tempDao;
    }

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
        user.setUserUuid(StrUtil.getUuid());
        String password_salt = StrUtil.getUuid();

        user.setPassword_salt(password_salt);
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
                    integers.add(NumberUtil.parseInt(s));
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


}
