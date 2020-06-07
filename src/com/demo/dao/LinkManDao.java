package com.demo.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.demo.bean.LinkMan;
import com.demo.bean.PageBean;

public interface LinkManDao {

	Integer findCount(DetachedCriteria detachedCriteria);

	List<LinkMan> findByPage(DetachedCriteria detachedCriteria, Integer beginIndex, Integer pageSize);

}
