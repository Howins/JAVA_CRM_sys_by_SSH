package com.demo.service;

import org.hibernate.criterion.DetachedCriteria;

import com.demo.bean.LinkMan;
import com.demo.bean.PageBean;

public interface LinkManService {

	PageBean<LinkMan> findByPage(DetachedCriteria detachedCriteria, Integer currPage, Integer pageSize);

	void save(LinkMan linkMan);

	LinkMan findById(Long lkm_id);

	void update(LinkMan linkMan);

	void delete(LinkMan linkMan);

}
