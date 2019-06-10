package com.empsys.employee.service;

import java.util.List;

import com.empsys.employee.dao.EmployeeDaoImpl;
import com.empsys.entity.Employee;
import com.empsys.entity.Job;
import com.empsys.job.dao.JobDaoImpl;

public class EmployeeServiceImpl {
	
	public List<Job> listJobs(){
		return new JobDaoImpl().findAllJobs();
	}
	
	public boolean addEmployee(Employee employee) {
		int count = new EmployeeDaoImpl().saveEmployee(employee);
		return count>0;
	}
}
