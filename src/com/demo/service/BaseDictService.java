package com.demo.service;

import java.util.List;

import com.demo.bean.BaseDict;

public interface BaseDictService {

	List<BaseDict> findByTypeCode(String dict_type_code);

}
