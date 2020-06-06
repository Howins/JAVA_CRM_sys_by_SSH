package com.demo.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.demo.bean.Customer;
import com.demo.bean.PageBean;

public interface CustomerService {

	List<Customer> findAll();

	void add(Customer customer);

	void update(Customer customer);

	void delete(Customer customer);

	Customer findById(Long cust_id);

	List<Customer> findQBC();

	PageBean<Customer> findByPage(DetachedCriteria detachedCriteria, Integer currPage, Integer pageSize);

}
