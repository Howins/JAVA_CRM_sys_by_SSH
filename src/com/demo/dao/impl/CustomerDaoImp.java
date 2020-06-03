package com.demo.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.demo.bean.Customer;
import com.demo.dao.CustomerDao;
import com.demo.utils.HibernateUtils;

public class CustomerDaoImp implements CustomerDao {

	public List<Customer> findAll() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();

		// query all customer list
		List<Customer> list = session.createQuery("from Customer").list();

		tx.commit();
		return list;
	}

	public void add(Customer customer) {
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();

		// add customer to DB
		session.save(customer);

		tx.commit();
	}

}
