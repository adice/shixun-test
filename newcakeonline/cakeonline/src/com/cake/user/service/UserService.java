package com.cake.user.service;

import com.cake.entity.User;
import com.cake.user.dao.UserDao;

public class UserService {

	public User login(String email, String password) {
		return new UserDao().findByEamilAndPassword(email, password);
	}
}
