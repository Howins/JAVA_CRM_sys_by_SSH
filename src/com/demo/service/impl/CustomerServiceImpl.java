package com.demo.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import com.demo.bean.Customer;
import com.demo.bean.PageBean;
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

	//业务层查询分类客户的方法:
	public PageBean<Customer> findByPage(DetachedCriteria detachedCriteria, Integer currPage, Integer pageSize) {
		PageBean<Customer> pageBean= new PageBean<Customer>();
		//封装当前页数，封装页容量（默认配一个）
		pageBean.setCurrPage(currPage);
		pageBean.setPageSize(pageSize);
		//封装总记录数
		Integer totalRecord = customerDao.findRecord(detachedCriteria);
		pageBean.setTotalRecord(totalRecord);
		//封装总页数：
		Double ceil = Math.ceil(totalRecord.doubleValue()/pageSize.doubleValue());
		Integer totalPage = ceil.intValue();
		pageBean.setTotalPage(totalPage);
		//封装每页显示数据的集合：
		Integer beginRecord = (currPage-1)*pageSize;
		List<Customer> list = customerDao.findByPage(detachedCriteria,beginRecord,pageSize);
		pageBean.setList(list);
		return pageBean;
	}

}
