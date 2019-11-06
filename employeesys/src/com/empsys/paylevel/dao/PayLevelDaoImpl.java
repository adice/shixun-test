package com.empsys.paylevel.dao;

import java.util.List;

import com.empsys.entity.PayLevel;
import com.empsys.util.DBUtil;

public class PayLevelDaoImpl {
	
	public List<PayLevel> findAll(){
		return DBUtil.find(PayLevel.class, "select * from paylevel", null);
	}

}
