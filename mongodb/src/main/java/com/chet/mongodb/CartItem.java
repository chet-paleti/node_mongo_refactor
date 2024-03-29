package com.chet.mongodb;

public class CartItem {
	
	
	private Product product ;
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	private int qty ;
	public CartItem() {
		
	}
	
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	
	
	
	

}
