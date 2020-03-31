package com.cakeonline.user.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cakeonline.entity.User;
import com.cakeonline.user.service.UserServiceImpl;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Resource
	private UserServiceImpl userServiceImpl;
	
	@RequestMapping("/regist")
	public void regist() {
		User u = new User();
		u.setEmail("aa");
		u.setNickName("aa");
		u.setPassword("aa");
		u.setRegistTime(new Date());
		this.userServiceImpl.addUser(u);
		
	}
	
	@RequestMapping("/list")
	public String list(Model model) {
		List<User> users = this.userServiceImpl.listUsers();
		model.addAttribute("users", users);
		return "list";
	}

}
