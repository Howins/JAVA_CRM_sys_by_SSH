package com.demo.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.demo.bean.User;
import com.demo.dao.UserDao;
import com.demo.utils.HibernateUtils;

public class UserDaoImpl implements UserDao {

	public User login(User user) {
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		// after learned Spring it will more easy to get the query access
		Query query = session.createQuery("from User where user_code=? and user_password=?");
		query.setParameter(0, user.getUser_code());
		query.setParameter(1, user.getUser_password());
		
		List<User> list = query.list();
		if(list.size()>0){
			//get user
			return list.get(0);
		}
		tx.commit();
		return null;
	}

}
