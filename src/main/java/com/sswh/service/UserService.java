package com.sswh.service;


import com.sswh.entity.User;

import java.util.List;

public interface UserService {
	public void regist(User user);
	public User getByIid(int iid);
	public List<User> findAllUser();
	public List<User> findByIids(List<Integer> iids);
}
