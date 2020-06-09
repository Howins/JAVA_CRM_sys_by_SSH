package com.demo.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.demo.bean.PageBean;
import com.demo.bean.SaleVisit;

public interface SaleVisitService {

	Integer findRecord(DetachedCriteria detachedCriteria);

	PageBean findAllByPage(DetachedCriteria detachedCriteria, Integer beginRecord, Integer pageSize);

	void add(SaleVisit saleVisit);

}
