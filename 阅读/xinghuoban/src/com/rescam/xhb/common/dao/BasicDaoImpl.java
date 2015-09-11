package com.rescam.xhb.common.dao;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

@SuppressWarnings({ "unchecked", "rawtypes" })
public class BasicDaoImpl<T> extends HibernateDaoSupport implements BasicDao<T> {
	private Class<T> clazz;

	public Class<T> getClazz() {
		return clazz;

	}

	public void setClazz(Class<T> clazz) {
		this.clazz = clazz;
	}

	/**
	 * 获取这个实体类对象
	 */
	public BasicDaoImpl() {
		super();
		// 获取泛型中的具体类型
		ParameterizedType type = (ParameterizedType) this.getClass()
		        .getGenericSuperclass();
		this.clazz = (Class<T>) type.getActualTypeArguments()[0];
	}

	@Override
	public T findById(Integer id) throws HibernateException {
		return getHibernateTemplate().get(clazz, id);
	}

	@Override
	public void saveEntity(T entity) throws HibernateException {
		getHibernateTemplate().save(entity);
	}

	@Override
	public void deleteEntity(T entity) throws HibernateException {
		getHibernateTemplate().delete(entity);
	}

	@Override
	public void updateEntity(T entity) throws HibernateException {
		Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
		session.clear();
		getHibernateTemplate().update(entity);
	}

	@Override
	public Integer getCount(String hql, Object... params) {
		return getHibernateTemplate().find(hql, params).size();
	}

	@Override
	public List<T> findByPage(final String hql, final int currentpage,
	        final int pageSize, final Object... params) {
		return (List<T>) getHibernateTemplate().execute(
		        new HibernateCallback<T>() {

			        @Override
			        public T doInHibernate(Session session)
			                throws HibernateException {
				        Query query = session.createQuery(hql);
				        // 如果有指定查询参数则进行查询参数匹配
				        if (params != null) {
					        for (int i = 0; i < params.length; i++) {
						        query.setParameter(i, params[i]);
					        }
				        }
				        if (currentpage >= 1) {

					        query.setFirstResult((currentpage - 1) * pageSize)
					                .setMaxResults(pageSize);
				        } else {
					        query.setFirstResult(1).setMaxResults(pageSize);
				        }

				        return (T) query.list();
			        }
		        });
	}

	@Override
	public List<T> findByPage(final int currentpage, final int pageSize) {
		return (List<T>) getHibernateTemplate().execute(
		        new HibernateCallback<T>() {

			        @Override
			        public T doInHibernate(Session session)
			                throws HibernateException {
				        Query query = session.createQuery("FROM "
				                + clazz.getSimpleName() + " ");

				        if (currentpage >= 1) {

					        query.setFirstResult((currentpage - 1) * pageSize)
					                .setMaxResults(pageSize);
				        } else {
					        query.setFirstResult(1).setMaxResults(pageSize);
				        }
				        return (T) query.list();
			        }
		        });
	}

	@Override
	public Integer getCount() {
		return getHibernateTemplate()
		        .find("FROM " + clazz.getSimpleName() + "").size();
	}

	@Override
	public List findBySqlPage(final String sql, final int currentpage,
	        final int pageSize, final Object[] params) {
		return (List) getHibernateTemplate().execute(new HibernateCallback() {

			@Override
			public Object doInHibernate(Session session) {
				SQLQuery query = session.createSQLQuery(sql);
				// 如果有指定查询参数则进行查询参数匹配
				if (params != null) {
					for (int i = 0; i < params.length; i++) {
						if (params[i] != null)
							query.setParameter(i, params[i]);
					}
				}

				query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
				// 如果当前页大于等于1则采取分页，否则查询全部
				if (currentpage >= 1) {

					query.setFirstResult((currentpage - 1) * pageSize)
					        .setMaxResults(pageSize);
				}
				/*
				 * else { query.setFirstResult(1).setMaxResults(pageSize); }
				 */
				List result = query.list();
				List<HashMap<String, Object>> lm = new ArrayList<HashMap<String, Object>>();
				for (int i = 0; i < result.size(); i++) {
					HashMap<String, Object> m = (HashMap<String, Object>) result
					        .get(i);
					Iterator it = m.keySet().iterator();
					while (it.hasNext()) {
						String key = (String) it.next();
						if (m.get(key) == null) {
							m.put(key, "");
						}
					}
					lm.add(m);
				}
				return lm;
			}
		});
	}

	@Override
	public List getObjects(Class clazz) {
		return getHibernateTemplate().loadAll(clazz);
	}

	public List findBySql(String sql){
		Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
		SQLQuery sq =session.createSQLQuery(sql);
		return sq.list();
	}
	
	public int saveOrUpdateBySql(String sql) {
		int result ;
		Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
        SQLQuery query = session.createSQLQuery(sql);    
        result = query.executeUpdate();    
        return result;
	}
}
