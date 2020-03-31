package com.cakeonline.user.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.cakeonline.entity.User;

@Repository
public class UserDaoImpl {

	@Resource
	private SessionFactory sessionFactory;
	
	/**
	 * saveUser
	 * updateUser
	 * deleteUser
	 * findByName
	 * findById
	 * @return
	 */
	
	public void saveUser(User user) {
		System.out.println("dao");
		this.sessionFactory.getCurrentSession().save(user);
	}
	
	public List<User> findAll(){
		Query query = this.sessionFactory.getCurrentSession().createQuery("from User");
		return query.list();
	}
}
