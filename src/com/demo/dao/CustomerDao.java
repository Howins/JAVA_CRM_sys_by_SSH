package com.demo.dao;

import java.util.List;

import com.demo.bean.Customer;

public interface CustomerDao {

	List<Customer> findAll();

	void add(Customer customer);

	void update(Customer customer);

	void delete(Customer customer);

	List<Customer> findQBC();

	Customer findById(Long cust_id);

}
