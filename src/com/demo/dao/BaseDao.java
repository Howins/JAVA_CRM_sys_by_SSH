package com.demo.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

public interface BaseDao<T> {

	List<T> findAll();

	void add(T t);

	void update(T t);

	void delete(T t);

	List<T> findQBC();

	T findByCode(String codeName,String code);

	T findById(Serializable id);

	Integer findRecord(DetachedCriteria detachedCriteria);

	List<T> findByPage(DetachedCriteria detachedCriteria, Integer beginRecord, Integer pageSize);
}
