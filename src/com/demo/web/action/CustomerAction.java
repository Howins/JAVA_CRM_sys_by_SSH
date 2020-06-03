package com.demo.web.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.demo.bean.Customer;
import com.demo.service.CustomerService;
import com.demo.service.impl.CustomerServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

public class CustomerAction extends ActionSupport {

	/**
	 * get all the customer list from DB
	 * @return
	 */
	public String findAll(){
		System.out.println("来带Action。。。。。");
		// create Service object 
		CustomerService cs = new CustomerServiceImpl();
		// get custmer list from service object
		List<Customer> list = cs.findAll();
		// set parameters to page
		ServletActionContext.getRequest().setAttribute("list", list);
		return "findAll";
	}
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return super.execute();
	}
}
