package com.demo.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.demo.bean.Customer;
import com.demo.dao.CustomerDao;

public class CustomerDaoImp extends BaseDaoImpl<Customer> implements CustomerDao {


}
