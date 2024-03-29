package com.chet.mongodb;



import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



@Document("products")
public class Product {
	
    
	private String id;
	


	
	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	private String title;
	
	private Double price;
	
	private String imageurl;
	
	private String description;
	
public Product() {
		
	}


	public Product(String title, Double price, String imageurl, String description) {
	super();
	this.title = title;
	this.price = price;
	this.imageurl = imageurl;
	this.description = description;
}



	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getImageurl() {
		return imageurl;
	}

	public void setImageurl(String imageurl) {
		this.imageurl = imageurl;
	}

	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}

}
