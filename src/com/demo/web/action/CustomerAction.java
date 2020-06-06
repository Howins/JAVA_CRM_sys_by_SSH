package com.demo.web.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.demo.bean.Customer;
import com.demo.bean.PageBean;
import com.demo.service.CustomerService;
import com.demo.service.impl.CustomerServiceImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;

/**
 * Customer Managerment class
 * 
 * @author Howins
 *
 */
public class CustomerAction extends ActionSupport implements ModelDriven<Customer> {

	//使用Set方法接收数据
	private Integer currPage=1;
	public void setCurrPage(Integer currPage) {
		this.currPage = currPage;
	}
	private Integer pageSize=5;
	
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	/**
	 * the private customer and the getModel method for wrap the data into Model
	 * by Struts2
	 */
	private Customer customer = new Customer();

	public Customer getModel() {
		return customer;
	}

	private CustomerService customerService = new CustomerServiceImpl();

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	/**
	 * Add new Customer to DB
	 * 
	 * @return jump to the list to show the new customer
	 */
	public String add() {
		// get the infos from the form sheet by page
		// CustomerService cs = new CustomerServiceImpl();
		// using Spring to create the CustomerService
//		System.out.println(customer);
		customerService.add(customer);
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

		//接收分页参数
		//最好使用DetacheCriteria的对象(带分页的条件查询)
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Customer.class);
		//调用业务层查询
		PageBean<Customer> pageBean = customerService.findByPage(detachedCriteria,currPage,pageSize);

//		List<Customer> list = customerService.findAll();
		ActionContext.getContext().getValueStack().push(pageBean);
//		ValueStack valueStack = ActionContext.getContext().getValueStack();
//		valueStack.set("list", pageBean.getList());
		return "findAllSuccess";
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return super.execute();
	}

}
