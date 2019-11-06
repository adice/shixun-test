package com.empsys.job.service;

import java.util.List;
import java.util.Map;

import com.empsys.entity.Job;
import com.empsys.job.dao.JobDaoImpl;

public class JobServiceImpl {

	public List<Map<String, Object>> listJobs() {
		return new JobDaoImpl().findAll();
	}
	
	public List<Job> listAllJobs(){
		return new JobDaoImpl().findAllJobs();
	}

	public boolean addJob(Job job) {
		int count = new JobDaoImpl().saveJob(job);
		return count > 0;
	}

	public Job getJob(int id) {
		return new JobDaoImpl().findById(id);
	}

	public boolean editJob(Job job) {
		int count = new JobDaoImpl().updateJob(job);
		return count > 0;
	}

	public boolean dropJob(int id) {
		int count = new JobDaoImpl().deleteJob(id);
		return count > 0;
	}

}
