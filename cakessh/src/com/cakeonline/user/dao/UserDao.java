package com.cakeonline.user.dao;

import com.cakeonline.entity.User;
import com.cakeonline.util.BaseDao;

public class UserDao extends BaseDao<User, String>{
	public User findByNameAndPassword(String name, String password) {
		try {
			return this.findOne("from User u where u.email = ? and password = ?", new Object[] {name, password});
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
