package com.cakeonline.cake.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cakeonline.cake.service.CakeServiceImpl;
import com.cakeonline.entity.Cake;
import com.cakeonline.util.Page;

@Controller
@RequestMapping("/cake")
public class CakeController {
	
	@Resource
	private CakeServiceImpl cakeServiceImpl;
	
	@RequestMapping("/list")
	public String list(Model model, @RequestParam("type") int typeId, @RequestParam(value = "name", required = false) String name, 
			@RequestParam(value = "pageNum", defaultValue = "1") int pageNum) {
		Page<Cake> page = this.cakeServiceImpl.listCakes(typeId, name, pageNum, 9);
		model.addAttribute("page", page);
		return "products";
	}
	
	@RequestMapping("/get")
	public String getCake(Model model, @RequestParam("id") int id) {
		Cake cake = this.cakeServiceImpl.getCake(id);
		model.addAttribute("cake", cake);
		return "single";
	}

}
