package com.sswh.service.impl;

import com.sswh.dao.UserDao;
import com.sswh.entity.User;
import com.sswh.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service(value="userService")
public class UserServiceImpl implements UserService {
	
	@Resource(name="userDao")
	public UserDao dao;
	
	
	public void regist(User user){
		dao.regist(user);
		System.out.println("dao valid");
	}




}
