package com.rescam.xhb.common.service;

import java.util.List;

import org.hibernate.HibernateException;

import com.rescam.xhb.common.dao.BasicDao;

@SuppressWarnings("rawtypes")
public class BasicServiceImpl<T> implements BasicService<T> {
	private BasicDao<T> Dao;

	// 各个独立的service可以注入各个所需的Dao实现类
	public BasicDao<T> getDao() {
		return Dao;
	}

	public void setDao(BasicDao<T> dao) {
		Dao = dao;
	}

	@Override
	public T findById(Integer id) throws HibernateException {
		return Dao.findById(id);
	}

	@Override
	public void saveEntity(T entity) throws HibernateException {
		Dao.saveEntity(entity);
	}

	@Override
	public void deleteEntity(T entity) throws HibernateException {
		Dao.deleteEntity(entity);
	}

	@Override
	public void updateEntity(T entity) throws HibernateException {
		Dao.updateEntity(entity);
	}

	@Override
	public List<T> findByPage(String hql, int currentpage, int pageSize,
	        Object... params) {
		return Dao.findByPage(hql, currentpage, pageSize, params);
	}

	@Override
	public Integer getCount(String hql, List<Object> params) {
		return Dao.getCount(hql, params);
	}

	@Override
	public List<T> findByPage(int currentpage, int pageSize) {
		return Dao.findByPage(currentpage, pageSize);
	}

	@Override
	public Integer getCount() {
		return Dao.getCount();
	}

	@Override
	public List findBySqlPage(String sql, int currentpage, int pageSize,
	        Object[] params) {
		return Dao.findBySqlPage(sql, currentpage, pageSize, params);
	}

	@Override
	public List getObjects(Class clazz) {
		return Dao.getObjects(clazz);
	}

	@Override
	public List findBySql(String sql) {
		return Dao.findBySql(sql);
	}

	@Override
	public int saveOrUpdateBySql(String sql) {
		return Dao.saveOrUpdateBySql(sql);
	}
}
