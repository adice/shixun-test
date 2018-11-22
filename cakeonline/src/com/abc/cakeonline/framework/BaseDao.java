package com.abc.cakeonline.framework;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaSpecification;

import com.abc.cakeonline.util.Page;

public abstract class BaseDao<T, PK extends Serializable> {

	private Class<T> entityClass;

	@Resource
	private SessionFactory sessionFactory;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public BaseDao() {
		Class c = getClass();
		Type t = c.getGenericSuperclass();
		if (t instanceof ParameterizedType) {
			Type[] p = ((ParameterizedType) t).getActualTypeArguments();
			this.entityClass = (Class<T>) p[0];
		}
	}

	// **************基本增删改查*********************

	public void save(T entity) throws Exception {
		this.sessionFactory.getCurrentSession().save(entity);
	}

	public void update(T entity) throws Exception {
		this.sessionFactory.getCurrentSession().update(entity);
	}

	public void delete(Object entity) throws Exception {
		this.sessionFactory.getCurrentSession().delete(entity);
	}

	public void delete(Serializable id) throws Exception {
		this.delete(this.sessionFactory.getCurrentSession().load(entityClass, id));
	}

	public T get(Serializable id) throws Exception {
		return (T) this.sessionFactory.getCurrentSession().get(entityClass, id);
	}

	public T load(Serializable id) throws Exception {
		return (T) this.sessionFactory.getCurrentSession().load(entityClass, id);
	}

	// **************HQL***************************

	@SuppressWarnings("unchecked")
	public T findOne(String hql, Object[] params) throws Exception {
		Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
		if (params != null && params.length > 0) {
			for (int i = 0; i < params.length; i++)
				query.setParameter(i, params[i]);
		}
		return (T) query.uniqueResult();
	}

	/**
	 * 
	 * @desc 查询全部数据
	 * @author wangwei
	 * @createDate 2014年9月5日
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<T> findAll() throws Exception {
		Query query = this.sessionFactory.getCurrentSession().createQuery("from " + entityClass.getSimpleName());
		return query.list();
	}

	/**
	 * 
	 * @desc 按条件查询数据
	 * @author wangwei
	 * @createDate 2014年9月5日
	 * @param hql
	 * @param params
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<T> find(String hql, Object[] params) throws Exception {
		Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
		if (params != null && params.length > 0) {
			for (int i = 0; i < params.length; i++)
				query.setParameter(i, params[i]);
		}
		return query.list();
	}

	/**
	 * 
	 * @desc 统计全部数据数量
	 * @author wangwei
	 * @createDate 2014年9月5日
	 * @return
	 * @throws Exception
	 */
	public Long findCount() throws Exception {
		Query query = this.sessionFactory.getCurrentSession()
				.createQuery("select count(" + entityClass.getSimpleName() + "from " + entityClass.getSimpleName());
		return (Long) query.uniqueResult();
	}

	/**
	 * 
	 * @desc 分页查询全部数据
	 * @author wangwei
	 * @createDate 2014年9月5日
	 * @param pageNum
	 * @param pageSize
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public Page<T> findPage(int pageNum, int pageSize) throws Exception {
		long total = this.findCount();
		Query query = this.sessionFactory.getCurrentSession().createQuery("from " + entityClass.getSimpleName());
		query.setFirstResult((pageNum - 1) * pageSize);
		query.setMaxResults(pageSize);
		List<T> rows = query.list();
		return new Page<T>(pageNum, pageSize, (int) total, rows);
	}

	/**
	 * 
	 * @desc 按条件查询数据数量
	 * @author wangwei
	 * @createDate 2014年9月5日
	 * @param hql
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public Long findCount(String hql, Object[] params) throws Exception {
		Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
		if (params != null && params.length > 0) {
			for (int i = 0; i < params.length; i++)
				query.setParameter(i, params[i]);
		}
		return (Long) query.uniqueResult();
	}

	/**
	 * 
	 * @desc 按条件分页查询数据
	 * @author wangwei
	 * @createDate 2014年9月5日
	 * @param pageNum
	 * @param pageSize
	 * @param hql
	 * @param params
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<T> find(int pageNum, int pageSize, String hql, Object[] params) throws Exception {
		Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
		if (params != null && params.length > 0) {
			for (int i = 0; i < params.length; i++)
				query.setParameter(i, params[i]);
		}
		query.setFirstResult((pageNum - 1) * pageSize);
		query.setMaxResults(pageSize);
		return query.list();
	}

	/**
	 * 分页查询
	 * @param pageNum
	 * @param pageSize
	 * @param hql
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public Page<T> findPage(int pageNum, int pageSize, String hql, Object[] params) throws Exception {
		long total = findCount("select count(*) " + hql, params);
		List<T> rows = find(pageNum, pageSize, hql, params);
		return new Page<T>(pageNum, pageSize, (int)total, rows);
	}

	// **************SQL***************************
	/**
	 * 通过原生SQL进行新增，修改，删除
	 * 
	 * @param sql
	 * @return
	 */
	public int excuteBySql(String sql, Object[] params) throws Exception {
		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		if (params != null && params.length > 0) {
			for (int i = 0; i < params.length; i++)
				query.setParameter(i, params[i]);
		}
		return query.executeUpdate();
	}

	/**
	 * 通过原生SQL进行查询 返回单个结果集，以Map<String, Object>形式存放。
	 * 
	 * @param sql
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> findOneBySql(String sql, Object[] params) throws Exception {
		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setResultTransformer(CriteriaSpecification.ALIAS_TO_ENTITY_MAP);
		if (params != null && params.length > 0) {
			for (int i = 0; i < params.length; i++)
				query.setParameter(i, params[i]);
		}
		return (Map<String, Object>) query.uniqueResult();
	}

	/**
	 * 通过原生SQL进行查询 返回多个结果集，以List<Map<String, Object>>形式存放
	 * @param sql
	 * @param params sql语句中参数，参数为数组
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> findBySql(String sql, Object[] params) throws Exception {
		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setResultTransformer(CriteriaSpecification.ALIAS_TO_ENTITY_MAP);
		if (params != null && params.length > 0) {
			for (int i = 0; i < params.length; i++)
				query.setParameter(i, params[i]);
		}
		return query.list();
	}

	/**
	 * 
	 * @desc 分页原生SQL进行统计数量
	 * @author wangwei
	 * @createDate 2014年10月13日
	 * @param sql
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public Long findCountBySql(String sql, Object[] params) throws Exception {
		SQLQuery query = this.sessionFactory.getCurrentSession().createSQLQuery(sql);
		if (params != null && params.length > 0) {
			for (int i = 0; i < params.length; i++)
				query.setParameter(i, params[i]);
		}
		return (Long) query.uniqueResult();
	}

	/**
	 * 
	 * @desc 分页原生SQL进行查询
	 * @author wangwei
	 * @createDate 2014年9月5日
	 * @param sql
	 * @param params
	 * @param pageNum
	 * @param pageSize
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> findBySql(String sql, Object[] params, int pageNum, int pageSize)
			throws Exception {
		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setResultTransformer(CriteriaSpecification.ALIAS_TO_ENTITY_MAP);
		if (params != null && params.length > 0) {
			for (int i = 0; i < params.length; i++)
				query.setParameter(i, params[i]);
		}
		query.setFirstResult((pageNum - 1) * pageSize);
		query.setMaxResults(pageSize);
		return query.list();
	}

	/**
	 * @desc 分页原生SQL进行查询
	 * @param pageNum
	 * @param pageSize
	 * @param sql1
	 * @param sql2
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public Page<Map<String, Object>> findPageBySql(int pageNum, int pageSize, String sql1, String sql2, Object[] params)
			throws Exception {
		long total = this.findCountBySql(sql1, params);
		List<Map<String, Object>> rows = this.findBySql(sql2, params, pageNum, pageSize);
		return new Page<Map<String, Object>>(pageNum, pageSize, (int)total, rows);
	}

	// ******************SQL 参数为Map*******************
	/**
	 * @desc 分页原生SQL进行查询
	 * @param sql
	 * @param params sql语句中的参数，参数为Map
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<Map<String, Object>> findBySql(String sql, Map params) throws Exception {
		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setResultTransformer(CriteriaSpecification.ALIAS_TO_ENTITY_MAP);
		Iterator<String> keys = params.keySet().iterator();
		while (keys.hasNext()) {
			String key = keys.next();
			Object value = params.get(key);
			if (value instanceof Collection)
				query.setParameterList(key, (Collection) value);
			else
				query.setParameter(key, value);
		}
		return query.list();
	}

	/**
	 * @desc 分页原生SQL进行统计数量
	 * @author wangwei
	 * @createDate 2014年10月13日
	 * @param sql
	 * @param params
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Long findCountBySql(String sql, Map params) throws Exception {
		SQLQuery query = this.sessionFactory.getCurrentSession().createSQLQuery(sql);
		Iterator<String> keys = params.keySet().iterator();
		while (keys.hasNext()) {
			String key = keys.next();
			Object value = params.get(key);
			if (value instanceof Collection)
				query.setParameterList(key, (Collection) value);
			else
				query.setParameter(key, value);
		}
		return (Long)query.uniqueResult();
	}

	/**
	 * 分页原生SQL进行查询
	 * 
	 * @param sql
	 * @param params
	 * @param pageNum
	 * @param pageSize
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<Map<String, Object>> findBySql(String sql, Map params, int pageNum, int pageSize) throws Exception {
		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setResultTransformer(CriteriaSpecification.ALIAS_TO_ENTITY_MAP);
		Iterator<String> keys = params.keySet().iterator();
		while (keys.hasNext()) {
			String key = keys.next();
			Object value = params.get(key);
			if (value instanceof Collection)
				query.setParameterList(key, (Collection) value);
			else
				query.setParameter(key, value);
		}
		query.setFirstResult((pageNum - 1) * pageSize);
		query.setMaxResults(pageSize);
		return query.list();
	}

	/**
	 * @desc 分页原生SQL进行查询
	 * @param pageNum
	 * @param pageSize
	 * @param sql1
	 * @param sql2
	 * @param params
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	public Page<Map<String, Object>> findPageBySql(int pageNum, int pageSize, String sql1, String sql2, Map params)
			throws Exception {
		long total = this.findCountBySql(sql1, params);
		List<Map<String, Object>> rows = this.findBySql(sql2, params, pageNum, pageSize);
		return new Page<Map<String, Object>>(pageNum, pageSize, (int)total, rows);
	}
}
