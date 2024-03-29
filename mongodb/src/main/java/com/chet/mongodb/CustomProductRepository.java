package com.chet.mongodb;

import java.util.List;

public interface CustomProductRepository {
	
	void addtocart(Product product) ;
	
	List<CartItem> getcartitems() ;
	void removecartitems(String id) ;
	void createorder() ;

}
