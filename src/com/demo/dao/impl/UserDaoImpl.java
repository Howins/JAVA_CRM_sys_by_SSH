package com.demo.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.demo.bean.User;
import com.demo.dao.UserDao;

public class UserDaoImpl extends HibernateDaoSupport implements UserDao {

	public User login(User user) {
		// Session session = HibernateUtils.getCurrentSession();
		// Transaction tx = session.beginTransaction();

		// after learned Spring it will more easy to get the query access
		// Query query = session.createQuery("from User where user_code=? and
		// user_password=?");
		// query.setParameter(0, user.getUser_code());
		// query.setParameter(1, user.getUser_password());
		//
		// List<User> list = query.list();
		// if(list.size()>0){
		// //get user
		// return list.get(0);
		// }
		// tx.commit();

		List<User> list = (List<User>) this.getHibernateTemplate().find("from User where user_code=? and user_password=?", user.getUser_code(), user.getUser_password());
		if (list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	public boolean regist(User user) {
		List<User> list = (List<User>) this.getHibernateTemplate().find("from User where user_code=?", user.getUser_code());
		if(list.size()>0){
			return false;
		}else{
			this.getHibernateTemplate().save(user);
			return true;
		}
	}

	public List<User> findAll() {
		return (List<User>) this.getHibernateTemplate().find("from User");
	}

}
