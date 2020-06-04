package com.demo.service.impl;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.demo.bean.Customer;
import com.demo.dao.CustomerDao;
import com.demo.dao.impl.CustomerDaoImp;
import com.demo.service.CustomerService;

public class CustomerServiceImpl implements CustomerService {
	private CustomerDao customerDao;
	

	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	public List<Customer> findAll() {
		// create Dao object for query
//		CustomerDao cd = new CustomerDaoImp();
		//using Spring
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		CustomerDao customerDao = (CustomerDao) applicationContext.getBean("customerDao");
		return customerDao.findAll();

	}

	public void add(Customer customer) {
		CustomerDao cd = new CustomerDaoImp();
	    cd.add(customer);

	}

}
