package com.demo.web.action;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.demo.bean.Customer;
import com.demo.bean.LinkMan;
import com.demo.bean.PageBean;
import com.demo.service.CustomerService;
import com.demo.service.LinkManService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class LinkManAction extends ActionSupport implements ModelDriven<LinkMan> {

	// 模型驱动使用的对象
	private LinkMan linkMan = new LinkMan();

	public LinkMan getModel() {
		return linkMan;
	}

	// 注入Service
	private LinkManService linkManService;

	public void setLinkManService(LinkManService linkManService) {
		this.linkManService = linkManService;
	}

	private Integer currPage = 1;
	private Integer pageSize = 3;

	public void setCurrPage(Integer currPage) {
		if (currPage == null) {
			this.currPage = 1;
		}
		this.currPage = currPage;
	}

	public void setPageSize(Integer pageSize) {
		if (pageSize == null) {
			this.pageSize = 3;
		}
		this.pageSize = pageSize;
	}

	private CustomerService customerService;

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	// 分页查询所有联系人
	public String findAll() {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(LinkMan.class);
		PageBean<LinkMan> pageBean = linkManService.findByPage(detachedCriteria, currPage, pageSize);
		ActionContext.getContext().getValueStack().push(pageBean);
		return "findAllSuccess";
	}

	// 跳转saveUI
	public String saveUI() {
		// 实现同步查询所属客户的方法
		List<Customer> list = customerService.findAll();
		ActionContext.getContext().getValueStack().set("list", list);
		return "saveUI";
	}

	// 保存联系人的方法
	public String save() {
		linkManService.save(linkMan);
		return "saveSuccess";
	}
	
	public String edit(){
		//查询所有客户
		List<Customer> list = customerService.findAll();
		//查询当前联系人
		linkMan = linkManService.findById(linkMan.getLkm_id());
		//把客户列表和联系人带到修改页面上
		ActionContext.getContext().getValueStack().set("list", list);
		ActionContext.getContext().getValueStack().push(linkMan);
		return "editSuccess";
	}
	
	public String update(){
		linkManService.update(linkMan);
		return "updateSuccess";
	}
	
	public String delete(){
		linkMan = linkManService.findById(linkMan.getLkm_id());
		linkManService.delete(linkMan);
		return "deleteSuccess";
	}
}
