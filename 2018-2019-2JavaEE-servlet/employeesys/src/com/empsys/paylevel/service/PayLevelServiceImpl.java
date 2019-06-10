package com.empsys.paylevel.service;

import java.util.List;

import com.empsys.entity.PayLevel;
import com.empsys.paylevel.dao.PayLevelDaoImpl;

public class PayLevelServiceImpl {

	public List<PayLevel> listPayLevels(){
		return new PayLevelDaoImpl().findAll();
	}
}
