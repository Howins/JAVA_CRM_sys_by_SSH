package com.demo.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.demo.bean.User;
import com.demo.dao.UserDao;
import com.demo.service.UserService;
import com.demo.utils.MD5Utils;

@Transactional
public class UserServiceImpl implements UserService {
	private UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public User login(User user) {
		user.setUser_password(MD5Utils.md5(user.getUser_password()));
		return userDao.login(user);

	}

	public boolean regist(User user) {
		user.setUser_password(MD5Utils.md5(user.getUser_password()));
		return userDao.regist(user);
	}

	public List<User> findAll() {
		return userDao.findAll();
	}

}
