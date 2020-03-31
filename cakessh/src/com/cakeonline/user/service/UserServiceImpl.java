package com.cakeonline.user.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cakeonline.entity.User;
import com.cakeonline.user.dao.UserDaoImpl;

@Service
@Transactional(readOnly = true)
public class UserServiceImpl {
	
	@Resource
	private UserDaoImpl userDaoImpl;
	/**
	 * regist
	 * login
	 * @return
	 */
	public List<User> listUsers(){
		return this.userDaoImpl.findAll();
	}
	
	@Transactional(readOnly = false)
	public void addUser(User user) {
		System.out.println("service");
		this.userDaoImpl.saveUser(user);
	}
}
