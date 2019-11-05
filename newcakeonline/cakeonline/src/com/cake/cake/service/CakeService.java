package com.cake.cake.service;

import java.util.List;

import com.cake.cake.dao.CakeDao;
import com.cake.entity.Cake;
import com.cake.util.Page;

public class CakeService {
	
	public Page<Cake> listCakes(int type, String name, int pageNum, int pageSize){
		Page<Cake> page = new Page<Cake>(pageNum, pageSize);
		CakeDao cakeDao = new CakeDao();
		int count = cakeDao.countByType(type, name);
		List<Cake> list = cakeDao.findByType(type, name, pageNum, pageSize);
		page.setList(list);
		page.setTotalCount(count);
		return page;
	}

	public List<Cake> listCakes(int type, String name){
		return new CakeDao().findByType(type, name);
	}
	
	public Cake getCake(int id) {
		return new CakeDao().findById(id);
	}
}
