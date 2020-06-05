package com.demo.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.demo.bean.Customer;
import com.demo.dao.CustomerDao;

public class CustomerDaoImp extends HibernateDaoSupport implements CustomerDao {

	public List<Customer> findAll() {
		// Session session = HibernateUtils.getCurrentSession();
		// Transaction tx = session.beginTransaction();
		// query all customer list
		// List<Customer> list = session.createQuery("from Customer").list();

		// tx.commit();
		List<Customer> list = (List<Customer>) this.getHibernateTemplate().find("from Customer");
		return list;
	}

	public void add(Customer customer) {
		this.getHibernateTemplate().save(customer);
		// System.out.println("customerDaoImpl 执行了。。。");
	}

	public void update(Customer customer) {
		this.getHibernateTemplate().update(customer);
	}

	public Customer findById(Long cust_id) {
		return this.getHibernateTemplate().get(Customer.class, cust_id);
	}

	public void delete(Customer customer) {
		this.getHibernateTemplate().delete(customer);
	}

	public List<Customer> findQBC() {
		DetachedCriteria cri = DetachedCriteria.forClass(Customer.class);
		return (List<Customer>) this.getHibernateTemplate().findByCriteria(cri);
	}

}
