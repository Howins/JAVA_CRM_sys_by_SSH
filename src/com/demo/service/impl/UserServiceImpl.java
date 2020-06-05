package com.demo.service.impl;

import org.springframework.transaction.annotation.Transactional;

import com.demo.bean.User;
import com.demo.dao.UserDao;
import com.demo.service.UserService;

@Transactional
public class UserServiceImpl implements UserService {
	private UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public User login(User user) {
		return userDao.login(user);

	}

}
