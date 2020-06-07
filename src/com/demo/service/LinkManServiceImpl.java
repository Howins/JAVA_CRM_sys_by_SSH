package com.demo.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.demo.bean.LinkMan;
import com.demo.bean.PageBean;
import com.demo.dao.LinkManDao;

public class LinkManServiceImpl implements LinkManService {

	private LinkManDao linkManDao;

	public void setLinkManDao(LinkManDao linkManDao) {
		this.linkManDao = linkManDao;
	}

	// 业务层分页查询联系人
	public PageBean<LinkMan> findByPage(DetachedCriteria detachedCriteria, Integer currPage, Integer pageSize) {
		PageBean<LinkMan> pageBean = new PageBean<LinkMan>();
		pageBean.setCurrPage(currPage);
		pageBean.setPageSize(pageSize);
		// 获取总记录数
		Integer totalRecord = linkManDao.findCount(detachedCriteria);
		Double tr = totalRecord.doubleValue();
		pageBean.setTotalRecord(totalRecord);
		// 获取总页数
		Double totalPage = Math.ceil(tr / pageSize.doubleValue());
		pageBean.setTotalPage(totalPage.intValue());
		// 设置当前起始记录
		Integer beginIndex = (currPage - 1) * pageSize;
		// 分页查询联系人
		List<LinkMan> list = (List<LinkMan>) linkManDao.findByPage(detachedCriteria, beginIndex, pageSize);
		pageBean.setList(list);
		return pageBean;
	}
}
