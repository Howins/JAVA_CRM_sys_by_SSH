package com.demo.web.action;

import org.apache.struts2.ServletActionContext;

import com.demo.bean.User;
import com.demo.service.UserService;
import com.demo.service.impl.UserServiceImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UserAction extends ActionSupport implements ModelDriven<User> {

	private User user = new User();

	public User getModel() {
		return user;
	}

	public String login() {
		// test for get the parameter from the form sheet
		// System.out.println(user);
		UserService uService = new UserServiceImpl();
		User existUser = uService.login(user);
		// according the result to jump different page
		if (existUser == null) {
			this.addActionError("UserName or Password Wrong!!!");
			return LOGIN;
		} else {
			// set parameter to page
			// ActionContext.getContext().getSession().put("user", existUser);
			ServletActionContext.getRequest().getSession().setAttribute("existUser", existUser);
			return SUCCESS;
		}
	}

}
