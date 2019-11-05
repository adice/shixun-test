package com.cake.type.service;

import java.util.List;

import com.cake.entity.Type;
import com.cake.type.dao.TypeDao;

public class TypeService {
	public List<Type> listTypes(){
		TypeDao typeDao = new TypeDao();
		return typeDao.findTopType();
	}
}
