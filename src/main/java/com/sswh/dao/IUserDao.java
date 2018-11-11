package com.sswh.dao;

import com.sswh.entity.User;

public interface IUserDao {
    User selectUser(long id);
}
