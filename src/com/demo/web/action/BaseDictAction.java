package com.demo.web.action;

import java.io.IOException;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.demo.bean.BaseDict;
import com.demo.service.BaseDictService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

public class BaseDictAction extends ActionSupport implements ModelDriven<BaseDict> {
	// 模型驱动
	private BaseDict baseDict = new BaseDict();

	public BaseDict getModel() {
		return baseDict;
	}

	// 注入Service
	private BaseDictService baseDictService;

	public void setBaseDictService(BaseDictService baseDictService) {
		this.baseDictService = baseDictService;
	}

	//findByTypeCode
	public String findByTypeCode() throws IOException{
		
		List<BaseDict> list = baseDictService.findByTypeCode(baseDict.getDict_type_code());
		//从网页过来的异步请求，直接返回JSON 即可
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.setExcludes(new String[]{"dict_sort","dict_enable","dict_memo"});
		JSONArray fromObject = JSONArray.fromObject(list,jsonConfig);
		ServletActionContext.getResponse().setContentType("html/text;charset=utf-8");
		ServletActionContext.getResponse().getWriter().println(fromObject.toString());
		return NONE;
	}
	
}
