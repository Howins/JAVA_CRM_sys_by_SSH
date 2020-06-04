package com.demo.service.impl;

import com.demo.bean.User;
import com.demo.dao.UserDao;
import com.demo.dao.impl.UserDaoImpl;
import com.demo.service.UserService;

public class UserServiceImpl implements UserService {

	public User login(User user) {
		UserDao uDao = new UserDaoImpl();
		return uDao.login(user);

	}

}
