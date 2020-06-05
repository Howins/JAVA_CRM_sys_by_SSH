package com.demo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.demo.bean.Customer;
import com.demo.service.CustomerService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class CustomerTest {

	// @Resource(name="customerService")// 不知道为什么用不了。。。
	@Autowired
	@Qualifier(value = "customerService")
	private CustomerService customerService;

	@Test
	public void demo1() {
		Customer customer = customerService.findById(6l);
		System.out.println(customer);
		customer.setCust_name("随便改");
		customerService.update(customer);
		System.out.println(customer);
	}
	
	@Test
	public void demo2(){
		
		customerService.delete(customerService.findById(6l));
	}
}
