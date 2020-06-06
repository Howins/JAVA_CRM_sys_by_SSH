package com.demo.dao;

import java.util.List;

import com.demo.bean.BaseDict;

public interface BaseDictDao {

	List<BaseDict> findByTypeCode(String dict_type_code);

}
