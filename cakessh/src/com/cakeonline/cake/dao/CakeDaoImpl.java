package com.cakeonline.cake.dao;

import org.springframework.stereotype.Repository;

import com.cakeonline.entity.Cake;
import com.cakeonline.util.BaseDao;
import com.cakeonline.util.Page;

@Repository
public class CakeDaoImpl extends BaseDao<Cake, Integer> {
	
	public Cake findOne(int id) {
		try {
			return super.get(id);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public Page<Cake> findCakes(int typeId, String name, int pageNum, int pageSize){
		try {
			if(name!=null && !name.equals("")) {
				return super.findPageByProperty(pageNum, pageSize,
							"from Cake c where c.type.id = ? and c.name like ?",new Object[] {typeId, "%"+name+"%"});
			}else {
				return super.findPageByProperty(pageNum, pageSize,
					"from Cake c where c.type.id = ?", new Object[] {typeId});
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
