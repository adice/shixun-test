package com.cakeonline.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_type")
public class Type {
	private int id;
	private String name;
	
	private Type parentType;
	private Set<Type> childTypes = new HashSet<Type>();
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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
	@ManyToOne
	@JoinColumn(name = "parentId")
	public Type getParentType() {
		return parentType;
	}
	public void setParentType(Type parentType) {
		this.parentType = parentType;
	}
	@OneToMany(mappedBy = "parentType")
	public Set<Type> getChildTypes() {
		return childTypes;
	}
	public void setChildTypes(Set<Type> childTypes) {
		this.childTypes = childTypes;
	}
}
