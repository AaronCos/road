package com.sswh.dao;

import com.sswh.entity.User;

import java.util.List;

public interface UserDao {
	/**
	 * 插入一条完整的用户信息
	 * @param user
	 * @return
	 */
	public boolean regist(User user);

	/**
	 * 通过用户id获取一条用户的信息
	 * @param iid
	 * @return
	 */
	public User getByIid(int iid);

	/**
	 * 获取所有用户
	 * @return
	 */
	public List<User> findAllUser();

	/**
	 * 批量获取用户的信息
	 * @param iids
	 * @return
	 */
	List<User> findByIids(List<Integer> iids);
}
