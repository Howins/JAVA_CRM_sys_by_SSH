package com.demo.service;

import java.util.List;

import com.demo.bean.User;

public interface UserService {

	User login(User user);

	boolean regist(User user);

	List<User> findAll();

}
