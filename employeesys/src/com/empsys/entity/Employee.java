package com.empsys.entity;

public class Employee {
	private int id;
	private String name;
	private int jobId;
	private int payLevelId;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getJobId() {
		return jobId;
	}
	public void setJobId(int jobId) {
		this.jobId = jobId;
	}
	public int getPayLevelId() {
		return payLevelId;
	}
	public void setPayLevelId(int payLevelId) {
		this.payLevelId = payLevelId;
	}
	
}
