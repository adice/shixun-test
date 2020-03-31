package com.cakeonline.index.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cakeonline.entity.Type;
import com.cakeonline.type.service.TypeService;

@Controller
public class IndexController {
	
	@Resource
	private TypeService typeService;

	@RequestMapping("/index")
	public String index(Model model, HttpSession session) {
		System.out.println("index");
		List<Type> list = this.typeService.listOneLevel();
		session.setAttribute("types", list);
		return "index";
	}
}
