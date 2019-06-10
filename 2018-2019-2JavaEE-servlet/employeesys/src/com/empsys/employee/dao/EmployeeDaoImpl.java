package com.empsys.employee.dao;

import com.empsys.entity.Employee;
import com.empsys.util.DBUtil;

public class EmployeeDaoImpl {
	public int saveEmployee(Employee employee) {
		return DBUtil.executeUpdate("insert into employee(name, jobId) values (?,?)", new Object[] {employee.getName(), employee.getJobId()});
	}
}
