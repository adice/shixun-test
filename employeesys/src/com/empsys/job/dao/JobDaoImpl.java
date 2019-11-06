package com.empsys.job.dao;

import java.util.List;
import java.util.Map;

import com.empsys.entity.Job;
import com.empsys.util.DBUtil;

public class JobDaoImpl {

	public List<Map<String, Object>> findAll() {
		return DBUtil.findAll("select * from job");
	}
	
	public List<Job> findAllJobs(){
		return DBUtil.find(Job.class, "select * from job", null);
	}

	public int saveJob(Job job) {
		return DBUtil.executeUpdate("insert into job (name) values (?)", new Object[] { job.getName() });
	}

	public Job findById(int id) {
		Object obj = DBUtil.findById(Job.class, id);
		return obj != null ? (Job)obj : null;
	}
	
	public int updateJob(Job job) {
		return DBUtil.executeUpdate("update job set name=? where id=?", new Object[] {job.getName(), job.getId()});
	}
	
	public int deleteJob(int id) {
		return DBUtil.executeUpdate("delete from job where id=?", new Object[] {id});
	}

}
