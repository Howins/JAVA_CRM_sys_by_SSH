package com.demo.service.impl;

import java.util.List;

import com.demo.bean.Customer;
import com.demo.dao.CustomerDao;
import com.demo.dao.impl.CustomerDaoImp;
import com.demo.service.CustomerService;

public class CustomerServiceImpl implements CustomerService {

	public List<Customer> findAll() {
		// create Dao object for query
		CustomerDao cd = new CustomerDaoImp();
		return cd.findAll();

	}

}
