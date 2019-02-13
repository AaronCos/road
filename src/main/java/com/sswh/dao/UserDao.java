package com.sswh.dao;

import com.sswh.entity.User;

import java.util.List;

public interface UserDao {
	public boolean regist(User user);
	public User getByIid(int iid);
	public List<User> findAllUser();
}
