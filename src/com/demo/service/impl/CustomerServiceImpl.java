package com.demo.service.impl;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import com.demo.bean.Customer;
import com.demo.dao.CustomerDao;
import com.demo.dao.impl.CustomerDaoImp;
import com.demo.service.CustomerService;

@Transactional
public class CustomerServiceImpl implements CustomerService {
	// add the object and the setter method for Spring
	private CustomerDao customerDao;

	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	public List<Customer> findAll() {
		return customerDao.findAll();
	}

	public void add(Customer customer) {
		System.out.println("customerService 执行拉。。。");
		customerDao.add(customer);
	}

	public void update(Customer customer) {
		customerDao.update(customer);
	}

	public void delete(Customer customer) {
		customerDao.delete(customer);
	}

	public Customer findById(Long cust_id) {
		return customerDao.findById(cust_id);
	}

	public List<Customer> findQBC() {
		return customerDao.findQBC();
	}

}
