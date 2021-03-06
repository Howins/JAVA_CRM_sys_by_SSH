package com.demo.web.action;

import java.io.IOException;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.demo.bean.User;
import com.demo.service.UserService;
import com.demo.service.impl.UserServiceImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

public class UserAction extends ActionSupport implements ModelDriven<User> {

	private User user = new User();

	public User getModel() {
		return user;
	}

	private UserService userService;
	
	public void setUser(User user) {
		this.user = user;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public String login() {
		// test for get the parameter from the form sheet
		// System.out.println(user);
		
		//using Spring to get the UserService
		//ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		//applicationContext.getBean("UserServiceImpl")
		User existUser = userService.login(user);
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
//		return null;
	}

	public String registUI(){
		return "registUI";
	}
	
	public String regist(){
		boolean registResult = userService.regist(user);
		if(registResult){
			this.addActionError("注册成功，请登录！！！");
			return LOGIN;
		}else{
			this.addActionError("用户名已存在，请重新注册！！！");
			return "regist";
		} 
	}
	
	public String findAllUser() throws IOException{
		List<User> list =userService.findAll();
		//设置到Json
		JSONArray jsonArray = JSONArray.fromObject(list);
		ServletActionContext.getResponse().setContentType("text/html;charset=utf-8");
		ServletActionContext.getResponse().getWriter().println(jsonArray.toString());
		return NONE;
	}
	
}
