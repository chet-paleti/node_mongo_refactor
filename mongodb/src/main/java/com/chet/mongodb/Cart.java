package com.chet.mongodb;

import java.util.List;


public class Cart {
	
	private  List<CartItem> Items ;

	public Cart() {
	
	}

	public List<CartItem> getItems() {
		return Items;
	}

	public void setItems(List<CartItem> items) {
		Items = items;
	}
	
	
	
	

}
