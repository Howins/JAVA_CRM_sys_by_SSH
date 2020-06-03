package com.demo.web.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.demo.bean.Customer;
import com.demo.service.CustomerService;
import com.demo.service.impl.CustomerServiceImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;

public class CustomerAction extends ActionSupport implements ModelDriven<Customer> {

	/**
	 * the private customer and the getModel method for wrap the data into Model
	 * by Struts2
	 */
	private Customer customer = new Customer();

	public Customer getModel() {
		return customer;
	}

	/**
	 * Add new Customer to DB
	 * 
	 * @return jump to the list to show the new customer
	 */
	public String add() {
		// get the infos from the form sheet by page
		CustomerService cs = new CustomerServiceImpl();
		cs.add(customer);

		return "addSuccess";
	}

	public String addUI() {
		return "addUI";
	}

	/**
	 * get all the customer list from DB
	 * 
	 * @return
	 */
	public String findAll() {
		// create Service object
		CustomerService cs = new CustomerServiceImpl();
		// get custmer list from service object
		List<Customer> list = cs.findAll();
		// set parameters to page
		//ServletActionContext.getRequest().setAttribute("list", list);
		//using ognl to fetch the data
		ValueStack valueStack = ActionContext.getContext().getValueStack();
		valueStack.set("list", list);
		return "findAllSuccess";
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return super.execute();
	}

}
