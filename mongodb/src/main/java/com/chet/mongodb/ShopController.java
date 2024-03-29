package com.chet.mongodb;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/shop")
public class ShopController {
	
	//@Autowired
	//private ShopService shopservice;
	
	@Autowired
	private ProductRepository product_repo;
	
	@Autowired
	private OrderRepository order_repo;
	
	@GetMapping("/home")
	public String ShopHome(Model mymodel) {
		
		List<Product> products =new ArrayList<>();
		
		products = product_repo.findAll();
		
		
		mymodel.addAttribute("products", products);
		
		return "shop";
	}
	
	@GetMapping("/product/{productid}")
	public String getEmployee(@PathVariable String productid, Model mymodel) {
		
		Optional<Product> product = product_repo.findById(productid);
		
		if (product.get() == null) {
			throw new RuntimeException("Product id not found - " + productid);
		}
		
		
		mymodel.addAttribute("product", product.get());
		
		return "shop-product";
	}
	
	@GetMapping("/cart")
	public String getCart(Model mymodel) {
		
		//List<CartItem> cartitems = shopservice.getCart() ;
		List<CartItem> cartitems = product_repo.getcartitems() ;
		mymodel.addAttribute("cartitems", cartitems);
		
		return "cart";
	}
	
	@PostMapping("/add-cart")
	public String postAddCart(@RequestParam("productId") String prodid, Model mymodel) {
		
		//shopservice.addCart(prodid);
		Optional<Product> p = product_repo.findById(prodid) ;
		product_repo.addtocart(p.get()) ;
		return "redirect:cart";
	}
	
	@PostMapping("/cart-delete-item")
	public String delCartItem(@RequestParam("cartitemid") String cartitemid, Model mymodel) {
		
		//shopservice.delCartItem(cartitemid);
		product_repo.removecartitems(cartitemid) ;
		return "redirect:cart";
	}
	
	@GetMapping("/orders")
	public String getOrders(Model mymodel) {
		
		//List<Order> orders = shopservice.getOrders() ;
		
		List<Order> orders =new ArrayList<>();
		
		orders = order_repo.findAll();
		mymodel.addAttribute("orders", orders);
		
		return "order";
	}
	
	@PostMapping("/create-order")
	public String delCartItem(Model mymodel) {
		
		//shopservice.createOrder();
		product_repo.createorder() ;
		return "redirect:orders";
	}
	
	

}
