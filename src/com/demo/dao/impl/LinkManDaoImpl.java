package com.demo.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.demo.bean.LinkMan;
import com.demo.bean.PageBean;
import com.demo.dao.LinkManDao;

public class LinkManDaoImpl extends HibernateDaoSupport implements LinkManDao {

	public Integer findCount(DetachedCriteria detachedCriteria) {
		detachedCriteria.setProjection(Projections.rowCount());
		List<Long> list = (List<Long>) this.getHibernateTemplate().findByCriteria(detachedCriteria);
		if(list.size()>0){
			return list.get(0).intValue();
		}
		return null;
	}

	public List<LinkMan> findByPage(DetachedCriteria detachedCriteria, Integer beginIndex, Integer pageSize) {
		detachedCriteria.setProjection(null);
		List<LinkMan> list = (List<LinkMan>) this.getHibernateTemplate().findByCriteria(detachedCriteria,beginIndex,pageSize);
		return list;
	}



}
