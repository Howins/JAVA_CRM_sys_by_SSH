package com.demo.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.demo.bean.Customer;
import com.demo.dao.CustomerDao;

public class CustomerDaoImp extends HibernateDaoSupport implements CustomerDao {

	public List<Customer> findAll() {
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

	public Integer findRecord(DetachedCriteria detachedCriteria) {
		// 设置条件，查询所有行的个数（返回记录数）
		detachedCriteria.setProjection(Projections.rowCount());
		List<Long> list = (List<Long>) this.getHibernateTemplate().findByCriteria(detachedCriteria);
		if (list.size() > 0) {
			return list.get(0).intValue();
		}
		return null;
	}

	public List<Customer> findByPage(DetachedCriteria detachedCriteria, Integer beginRecord, Integer pageSize) {
		//清空上面记录的限制条件
		detachedCriteria.setProjection(null);
		return (List<Customer>) this.getHibernateTemplate().findByCriteria(detachedCriteria, beginRecord, pageSize);

	}

}
