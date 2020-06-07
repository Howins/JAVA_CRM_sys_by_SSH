package com.demo.web.action;

import org.hibernate.criterion.DetachedCriteria;

import com.demo.bean.LinkMan;
import com.demo.bean.PageBean;
import com.demo.service.LinkManService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class LinkManAction extends ActionSupport implements ModelDriven<LinkMan> {

	//模型驱动使用的对象
	private LinkMan linkMan = new LinkMan();
	public LinkMan getModel() {
		return linkMan;
	}

	//注入Service
	private LinkManService linkManService;
	public void setLinkManService(LinkManService linkManService) {
		this.linkManService = linkManService;
	}
	
	private Integer currPage =1;
	private Integer pageSize =3;
	public void setCurrPage(Integer currPage) {
		if(currPage==null){
			this.currPage = 1;
		}
		this.currPage = currPage;
	}
	public void setPageSize(Integer pageSize) {
		if(pageSize==null){
			this.pageSize = 3;
		}
		this.pageSize = pageSize;
	}
	
	public String findAll(){
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(LinkMan.class);
		PageBean<LinkMan> pageBean = linkManService.findByPage(detachedCriteria,currPage,pageSize);
		ActionContext.getContext().getValueStack().push(pageBean);
		return "findAllSuccess";
	}
}
