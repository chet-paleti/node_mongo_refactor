package com.chet.mongodb;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@ComponentScan("chet")
@RequestMapping("/admin")
public class AdminController {
	
	//@Autowired
	//private ShopService shopservice;
	
	@Autowired
	private ProductRepository product_repo;
	
	
	@GetMapping("/products")
	public String ShopHome(Model mymodel) {
		
		List<Product> products =new ArrayList<>();
		
		products = product_repo.findAll();
		
		mymodel.addAttribute("products", products);
		
		return "admin-shop";
	}
	
	@GetMapping("/edit-product/{productid}")
	public String getProduct(@PathVariable String productid, Model mymodel) {
		
		Optional<Product> product = product_repo.findById(productid);
		
		System.out.println(product.get().getId()) ;
		
		
		
		if (product.get() == null) {
			throw new RuntimeException("Product id not found - " + productid);
		}
		
		
		mymodel.addAttribute("product", product.get());
		
		return "admin-product";
	}
	
	@GetMapping("/add-product")
	public String addProduct(Model myModel) {
		Product newproduct = new Product() ;
		myModel.addAttribute("product", newproduct);
		return "admin-product";
	}
	
	@PostMapping("/product")
	public String postProduct(@ModelAttribute("product") Product product) {
		
		//shopservice.saveProduct(product);
		System.out.println(product.getId()) ;
		if(product.getId() == "") {
			product.setId(null);
		}
		Product p = product_repo.save(product) ;
		
		return "redirect:products";
	}
	
	@PostMapping("/delete-product")
	public String postDeleteProduct(@RequestParam("productId") String prodid, Model mymodel) {
		
		//shopservice.delProduct(prodid);
		product_repo.deleteById(prodid) ;
		return "redirect:products";
	}

}
