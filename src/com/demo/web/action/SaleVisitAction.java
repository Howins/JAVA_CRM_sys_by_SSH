package com.demo.web.action;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.demo.bean.PageBean;
import com.demo.bean.SaleVisit;
import com.demo.service.SaleVisitService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class SaleVisitAction extends ActionSupport implements ModelDriven<SaleVisit> {
	private SaleVisit saleVisit = new SaleVisit();

	public SaleVisit getModel() {
		return saleVisit;
	}

	// 属性注入
	@Autowired
	@Qualifier(value = "saleVisitService")
	private SaleVisitService saleVisitService;

	public void setSaleVisitService(SaleVisitService saleVisitService) {
		this.saleVisitService = saleVisitService;
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

	// 使用分页查询相关数据
	public String findAll() {
		// 使用离线条件查询
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(SaleVisit.class);
		
		// 查询所有要显示的条目
		PageBean<SaleVisit> list = saleVisitService.findAllByPage(detachedCriteria, currPage, pageSize);
	
		ActionContext.getContext().getValueStack().push(list);
		return "findSuccess";
	}
	
	public String addUI(){
		return "addUI";
	}
	public String add(){
		saleVisitService.add(saleVisit);
		return "saveSuccess";
	}
}
