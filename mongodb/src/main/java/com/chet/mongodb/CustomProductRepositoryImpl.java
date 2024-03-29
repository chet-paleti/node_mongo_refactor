package com.chet.mongodb;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

public class CustomProductRepositoryImpl implements CustomProductRepository {
	
	 private final MongoTemplate mongoTemplate;

	    public CustomProductRepositoryImpl(MongoTemplate mongoTemplate) {
	        this.mongoTemplate= mongoTemplate;
	    }
	    
	    @Autowired
		private UserRepository user_repo;
	    
	    @Autowired
		private OrderRepository order_repo;

	@Override
	public void addtocart(Product product) {
		// TODO Auto-generated method stub
		
		//System.out.println("Adding product ") ;
		
		
		Optional<User> user = user_repo.findById("6547e8a28315d7eee1b69853") ;
		
		
		 Cart c = user.get().getCart() ;
		 
		 java.util.List<CartItem> items = c.getItems() ;
		 
		 int k = -1 ;
		 int newqty = 0 ;
		 
		 if(items == null) {
			 items = new ArrayList<CartItem>() ;
			
		 } else {
			 for(int i =0 ; i < items.size() ; i++ ) {
				 if(items.get(i).getProduct().getId().equals(product.getId())) {
					  k = i ;
					  break ;
				 }
				 
			 }
		 }
			 
		 if(k == -1) {
			 
			 CartItem ci = new CartItem() ;
			 ci.setProduct(product);
			 ci.setQty(1);
			 items.add(ci) ;
			 
		 } else {
			newqty = items.get(k).getQty() + 1 ;
			items.get(k).setQty(newqty);
			 
		 }
		 
		 	 
		 c.setItems(items);
		 user.get().setCart(c);
		 user_repo.save(user.get()) ;
		 
		
		
	}

	@Override
	public List<CartItem> getcartitems() {
		// TODO Auto-generated method stub
		Optional<User> user = user_repo.findById("6547e8a28315d7eee1b69853") ;
		return user.get().getCart().getItems();
	}

	@Override
	public void removecartitems(String id) {
		// TODO Auto-generated method stub
		Optional<User> user = user_repo.findById("6547e8a28315d7eee1b69853") ;
		List<CartItem> cartitems = user.get().getCart().getItems() ;
		cartitems = cartitems.stream().filter(ci -> !(ci.getProduct().getId().equals(id))).collect(Collectors.toList()) ;
		user.get().getCart().setItems(cartitems);
		user_repo.save(user.get()) ;
		System.out.println("Completed");
		
	}

	@Override
	public void createorder() {
		// TODO Auto-generated method stub
		
		Optional<User> user = user_repo.findById("6547e8a28315d7eee1b69853") ;
		List<CartItem> cartitems = user.get().getCart().getItems() ;
		Order o = new Order() ;
		o.setUser(user.get());
		o.setOrderitems(cartitems);
		order_repo.save(o) ;
		user.get().getCart().setItems(null);
		user_repo.save(user.get()) ;
		 
		
	}

}
