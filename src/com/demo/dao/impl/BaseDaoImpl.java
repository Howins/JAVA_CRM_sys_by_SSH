package com.demo.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.demo.dao.BaseDao;

public class BaseDaoImpl<T> extends HibernateDaoSupport implements BaseDao<T> {

	private Class clazz;

	// 编写无参构造，使用泛型反射获取泛型子类的类型
	public BaseDaoImpl() {
		//先获取子类的类型（this 指向当前使用的类）如：CustomerDaoImpl
		Class clazz = this.getClass();
		// 获得其子类的当前父类
		Type genericSuperclass = clazz.getGenericSuperclass();
		//由于 BaseDaoImpl<Customer> 这种形式叫（参数化类型）也是刚刚获得的父类类型，所以可以强转
		ParameterizedType type = (ParameterizedType)genericSuperclass;
		//通过参数化类型，获得实际类型的参数
		Type[] actualTypeArguments = type.getActualTypeArguments();
		// 这个是数组，因为存在Map<String,Value> 多个参数可能。但是这里我们自己知道只有一个//这样this.clazz 就是Customer 或者其他
		this.clazz = (Class) actualTypeArguments[0];
	}

	public List<T> findAll() {
		//clazz.getSimpleName() 获取泛型类的名字
		List<T> list = (List<T>) this.getHibernateTemplate().find("from "+clazz.getSimpleName());
		return list;
	}

	public void add(T t) {
		this.getHibernateTemplate().save(t);
	}

	public void update(T t) {
		this.getHibernateTemplate().update(t);
	}

	public void delete(T t) {
		this.getHibernateTemplate().delete(t);
	}

	public T findById(Serializable id) {
		return (T) this.getHibernateTemplate().get(clazz, id);
	}
	public T findByCode(String codeName, String code) {
		return (T) this.getHibernateTemplate().find("from "+clazz.getSimpleName()+" where "+codeName+" = ?",code);
	}
	public List<T> findQBC() {
		DetachedCriteria cri = DetachedCriteria.forClass(clazz);
		return (List<T>) this.getHibernateTemplate().findByCriteria(cri);
	}

	public Integer findRecord(DetachedCriteria detachedCriteria) {
		// 设置条件，查询所有行的个数（返回记录数）
		detachedCriteria.setProjection(Projections.rowCount());
		List<Long> list = (List<Long>) this.getHibernateTemplate().findByCriteria(detachedCriteria);
		if (list.size() > 0) {
			return list.get(0).intValue();
		}
		return null;
	}

	public List<T> findByPage(DetachedCriteria detachedCriteria, Integer beginRecord, Integer pageSize) {
		// 清空上面记录的限制条件
		detachedCriteria.setProjection(null);
		return (List<T>) this.getHibernateTemplate().findByCriteria(detachedCriteria, beginRecord, pageSize);

	}

}
