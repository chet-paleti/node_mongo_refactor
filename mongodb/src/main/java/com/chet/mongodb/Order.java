package com.chet.mongodb;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

@Document("orders")
public class Order {
	
	private String id;
	
	private User user ;
	
	private List<CartItem> orderitems ;
	
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<CartItem> getOrderitems() {
		return orderitems;
	}

	public void setOrderitems(List<CartItem> orderitems) {
		this.orderitems = orderitems;
	}
	
	
	

}
