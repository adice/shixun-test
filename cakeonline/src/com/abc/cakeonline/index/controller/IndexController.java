package com.abc.cakeonline.index.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.abc.cakeonline.entity.CakeType;
import com.abc.cakeonline.type.service.TypeServiceImpl;

@Controller
public class IndexController {
	
	@Resource
	private TypeServiceImpl typeServiceImpl;
	
	@RequestMapping("/index")
	public String index(HttpServletRequest request) {
		List<CakeType> list=this.typeServiceImpl.list();
		request.getServletContext().setAttribute("caketypes", list);
		return "main";
	}

}
