package com.sswh.platform.service.impl;

import com.sswh.platform.dao.IUsersDao;
import com.sswh.platform.entity.Users;
import com.sswh.platform.service.IUsersService;
import com.sswh.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by wangchengcheng on 2019/6/10
 */
@Service
public class UsersService implements IUsersService {
    @Autowired
    IUsersDao usersDao;

    @Override
    public boolean registUsers(Users users) {
        if(users != null){
            users.setPassword_salt(StringUtil.uuid());
        }
        String password = StringUtil.md5Util(users.getPassword(),users.getPassword_salt());
        users.setPassword(password);
        return usersDao.registerUser(users);
    }

    /**
     * 根据用户iid删除用户
     * @param iid
     * @return
     */
    @Override
    public int deleteByUserId(int iid) {
        int i = usersDao.deleteByUserId(iid);
        return i;
    }

    @Override
    public int findByUserName(String userName) {
        if(StringUtil.isEmpty(userName)){
            return 0;
        }
        return usersDao.findByUserName(userName);
    }

}
