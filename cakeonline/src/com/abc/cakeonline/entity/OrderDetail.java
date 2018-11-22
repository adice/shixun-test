package com.abc.cakeonline.entity;

public class OrderDetail {
	private int id;
	private int count;
	private Order order;
	private Cake cake;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public Cake getCake() {
		return cake;
	}
	public void setCake(Cake cake) {
		this.cake = cake;
	}

}
