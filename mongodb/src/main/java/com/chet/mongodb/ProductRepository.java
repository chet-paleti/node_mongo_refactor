package com.chet.mongodb;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> , CustomProductRepository {
	
	void addtocart(Product product) ;
	List<CartItem> getcartitems() ;
	void removecartitems(String id) ;
	void createorder() ;

}
