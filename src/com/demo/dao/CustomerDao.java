package com.demo.dao;

import java.util.List;

import com.demo.bean.Customer;

public interface CustomerDao {

	List<Customer> findAll();

	void add(Customer customer);

}
