package com.cakeonline.type.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cakeonline.entity.Type;
import com.cakeonline.util.BaseDao;

@Repository
public class TypeDao extends BaseDao<Type, Integer> {
	public List<Type> findOneLevel() {
		try {
			return this.findByProperty("from Type t where t.parentType is null", null);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
