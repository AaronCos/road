package com.sswh.service.impl;


import com.sswh.dao.UserDao;
import com.sswh.entity.User;
import com.sswh.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service(value="userService")
public class UserServiceImpl implements UserService {
	
	@Resource(name="userDao")
	public UserDao dao;
	
	
	public void regist(User user){
		System.out.printf("user:"+user.toString());
		dao.regist(user);
		System.out.println("dao valid");
	}

	public User getByIid(int iid){
		User user = dao.getByIid(1);
		return user;
	}

	@Override
	public List<User> findAllUser() {
		List<User> allUser = dao.findAllUser();
		return allUser;
	}


}
