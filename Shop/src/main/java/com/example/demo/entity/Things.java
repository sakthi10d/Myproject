package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Things {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int productId; 

	
String productName;
int ProductCount;
int productPrice;
public int getProductId() {
	return productId;
}
public void setProductId(int productId) {
	this.productId = productId;
}
public String getProductName() {
	return productName;
}
public void setProductName(String productName) {
	this.productName = productName;
}
public int getProductCount() {
	return ProductCount;
}
public void setProductCount(int productCount) {
	ProductCount = productCount;
}
public int getProductPrice() {
	return productPrice;
}
public void setProductPrice(int productPrice) {
	this.productPrice = productPrice;
}

}
