package com.demo.dao;

import java.util.List;

import com.demo.bean.User;

public interface UserDao {

	User login(User user);

	boolean regist(User user);

	List<User> findAll();

}
