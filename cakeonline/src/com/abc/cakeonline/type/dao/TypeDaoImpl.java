package com.abc.cakeonline.type.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.abc.cakeonline.entity.CakeType;
import com.abc.cakeonline.util.BaseDao;

@Repository
public class TypeDaoImpl extends BaseDao<CakeType, Integer>{
	
	public List<CakeType> findAll(){
		try {
			return this.find("from CakeType ct where ct.parentType = null", null);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
