package com.demo.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.transaction.annotation.Transactional;

import com.demo.bean.LinkMan;
import com.demo.bean.PageBean;
import com.demo.dao.LinkManDao;

@Transactional
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
		Integer totalRecord = linkManDao.findRecord(detachedCriteria);
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

	public void save(LinkMan linkMan) {
		linkManDao.add(linkMan);
	}

	public LinkMan findById(Long lkm_id) {
		return linkManDao.findById(lkm_id);

	}

	public void update(LinkMan linkMan) {
		linkManDao.update(linkMan);
	}

	public void delete(LinkMan linkMan) {
		linkManDao.delete(linkMan);
	}

}
