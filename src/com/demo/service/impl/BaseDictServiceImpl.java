package com.demo.service.impl;

import java.io.Serializable;
import java.util.List;

import com.demo.bean.BaseDict;
import com.demo.dao.BaseDictDao;
import com.demo.service.BaseDictService;

public class BaseDictServiceImpl implements BaseDictService {
	private BaseDictDao baseDictDao;

	public void setBaseDictDao(BaseDictDao baseDictDao) {
		this.baseDictDao = baseDictDao;
	}

	public List<BaseDict> findByTypeCode(String dict_type_code) {
		String codeName = "dict_type_code";
		return (List<BaseDict>) baseDictDao.findByCode(codeName,dict_type_code);
	}

}
