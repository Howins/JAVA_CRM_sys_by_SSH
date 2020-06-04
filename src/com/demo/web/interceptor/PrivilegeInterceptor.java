package com.demo.web.interceptor;

import org.apache.struts2.ServletActionContext;

import com.demo.bean.User;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class PrivilegeInterceptor extends MethodFilterInterceptor {

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		// check if the user login, find the existUser in session
		User existUser = (User) ServletActionContext.getRequest().getSession().getAttribute("existUser");
		// check if the existUser exist or not
		if (existUser == null) {
			// user didn't login
			ActionSupport action = (ActionSupport) invocation.getAction();
			action.addActionError("User didn't login, no privilege to access this page");
			return action.LOGIN;
		} else {
			// already login, go to next interceptor
			return invocation.invoke();
		}
	}

}
