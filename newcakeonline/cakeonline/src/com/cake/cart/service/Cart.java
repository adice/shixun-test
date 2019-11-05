package com.cake.cart.service;

import java.util.HashMap;
import java.util.Iterator;

import com.cake.entity.Cake;

public class Cart {
	public HashMap<Integer, CartItem> basket = new HashMap<Integer, CartItem>(0);
	
	public void add(Cake cake, int quantity) {
		if(basket.containsKey(cake.getId())) {
			CartItem ci = basket.get(cake.getId());
			ci.setQuantity(ci.getQuantity()+quantity);
		}else {
			CartItem ci = new CartItem();
			ci.setCake(cake);
			ci.setQuantity(quantity);
			basket.put(cake.getId(), ci);
		}
	}
	
	public String getInfo() {
		int sumPrice = 0;
		int sumQ = 0;
		Iterator i = basket.values().iterator();
		while(i.hasNext()) {
			CartItem ci = (CartItem)i.next();
			sumPrice += ci.getCake().getPrice()*ci.getQuantity();
			sumQ += ci.getQuantity();
		}
		return sumPrice+"("+sumQ+")";
	}

}
