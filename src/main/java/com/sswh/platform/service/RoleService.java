package com.sswh.platform.service;

import com.sswh.dao.PlatformRolesDao;
import com.sswh.entity.PlatformRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author nuanfeng
 * @date 2020/6/9 5:54
 */
@Service
public class RoleService extends CurrentPageData<PlatformRoles>{

    @Autowired
    PlatformRolesDao rolesDao;

    public List<PlatformRoles> findAllRoles(){
        List<PlatformRoles> allRoles = rolesDao.findAllRoles();
        return allRoles;
    }
    public List<PlatformRoles> findByName(String name){
        List<PlatformRoles> allRoles = rolesDao.findAllRoles();
        return allRoles;
    }


}
