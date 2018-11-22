package com.abc.cakeonline.entity;

import java.util.HashSet;
import java.util.Set;

public class Cake {
	private int id;
	private String name;
	private String description;
	private int prince;
	private CakeType cakeType;
	private Set<Comment> comments=new HashSet<Comment>();
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getPrince() {
		return prince;
	}
	public void setPrince(int prince) {
		this.prince = prince;
	}
	public CakeType getCakeType() {
		return cakeType;
	}
	public void setCakeType(CakeType cakeType) {
		this.cakeType = cakeType;
	}
	public Set<Comment> getComments() {
		return comments;
	}
	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}
	
}
