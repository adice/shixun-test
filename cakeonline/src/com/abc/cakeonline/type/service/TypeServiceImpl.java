package com.abc.cakeonline.type.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.abc.cakeonline.entity.CakeType;
import com.abc.cakeonline.type.dao.TypeDaoImpl;

@Service
@Transactional(readOnly=true)
public class TypeServiceImpl {
	
	@Resource
	private TypeDaoImpl typeDaoImpl;
	
	public List<CakeType> list(){
		return this.typeDaoImpl.findAll();
	}

}
