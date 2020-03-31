package com.cakeonline.type.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cakeonline.entity.Type;
import com.cakeonline.type.dao.TypeDao;

@Service
@Transactional(readOnly = true)
public class TypeService {
	@Resource
	private TypeDao typeDao;

	public List<Type> listOneLevel(){
		return this.typeDao.findOneLevel();
	}
}
