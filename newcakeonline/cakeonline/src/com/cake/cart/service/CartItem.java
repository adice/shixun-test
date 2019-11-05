package com.cake.cart.service;

import com.cake.entity.Cake;

public class CartItem {
	private Cake cake;
	private int quantity;
	public Cake getCake() {
		return cake;
	}
	public void setCake(Cake cake) {
		this.cake = cake;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
