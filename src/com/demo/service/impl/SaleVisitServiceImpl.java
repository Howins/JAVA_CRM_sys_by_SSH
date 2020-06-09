package com.demo.service.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import com.demo.bean.PageBean;
import com.demo.bean.SaleVisit;
import com.demo.dao.SaleVisitDao;
import com.demo.service.SaleVisitService;
@Transactional
public class SaleVisitServiceImpl implements SaleVisitService {

	@Autowired
	@Qualifier(value = "saleVisitDao")
	private SaleVisitDao saleVisitDao;

	public void setSaleVisitDao(SaleVisitDao saleVisitDao) {
		this.saleVisitDao = saleVisitDao;
	}

	public Integer findRecord(DetachedCriteria detachedCriteria) {
		return saleVisitDao.findRecord(detachedCriteria);
	}

	public PageBean findAllByPage(DetachedCriteria detachedCriteria, Integer currPage, Integer pageSize) {
		PageBean pageBean = new PageBean<SaleVisit>();
		pageBean.setCurrPage(currPage);
		pageBean.setPageSize(pageSize);
		// 获取总记录数
		Integer records = saleVisitDao.findRecord(detachedCriteria);
		pageBean.setTotalRecord(records);
		// 总共的页数
		Double totalPage = Math.ceil(records.doubleValue() / pageSize.doubleValue());
		pageBean.setTotalPage(totalPage.intValue());

		Integer beginRecord = (currPage - 1) * pageSize;
		List<SaleVisit> list = saleVisitDao.findByPage(detachedCriteria, beginRecord, pageSize);
		pageBean.setList(list);
		return pageBean;
	}

	public void add(SaleVisit saleVisit) {
		saleVisitDao.add(saleVisit);
	}

}
