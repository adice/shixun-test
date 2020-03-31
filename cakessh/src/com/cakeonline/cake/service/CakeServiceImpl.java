package com.cakeonline.cake.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cakeonline.cake.dao.CakeDaoImpl;
import com.cakeonline.entity.Cake;
import com.cakeonline.util.Page;

@Service
@Transactional(readOnly = true)
public class CakeServiceImpl {
	
	@Resource
	private CakeDaoImpl cakeDaoImpl;
	
	public Page<Cake> listCakes(int typeId, String name, int pageNum, int pageSize){
		return cakeDaoImpl.findCakes(typeId, name, pageNum, pageSize);
	}
	
	public Cake getCake(int id) {
		return this.cakeDaoImpl.findOne(id);
	}

}
