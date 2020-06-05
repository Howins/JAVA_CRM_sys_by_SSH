package com.demo.service;

import java.util.List;

import com.demo.bean.Customer;

public interface CustomerService {

	List<Customer> findAll();

	void add(Customer customer);

	void update(Customer customer);

	void delete(Customer customer);

	Customer findById(Long cust_id);

	List<Customer> findQBC();

}
