package com.demo.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.demo.bean.BaseDict;
import com.demo.dao.BaseDictDao;

public class BaseDictDaoImpl extends HibernateDaoSupport implements BaseDictDao {

	public List<BaseDict> findByTypeCode(String dict_type_code) {
		return (List<BaseDict>) getHibernateTemplate().find("from BaseDict where dict_type_code=?", dict_type_code);
	}

}
