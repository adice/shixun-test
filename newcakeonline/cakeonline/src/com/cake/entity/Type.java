package com.cake.entity;

import java.util.HashSet;
import java.util.Set;

public class Type {
	private int id;
	private String name;
	private int parentId;
	
	private Set<Type> types = new HashSet<Type>(0);

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

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public Set<Type> getTypes() {
		return types;
	}

	public void setTypes(Set<Type> types) {
		this.types = types;
	}

	
}
