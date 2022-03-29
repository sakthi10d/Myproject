package com.example.demo.entity;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.springframework.lang.NonNull;



@Entity
public class ProductEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ProductId",nullable = false)
	int productId;
	@Column(name = "ProductName",nullable = false)
	@NonNull
	String productName;
	@Column(name = "ProductPrice")
	int productPrice;
	@ManyToMany(cascade = CascadeType.ALL,mappedBy = "product")
	List<UserEntity> user;
	
	public ProductEntity() {

	}
	
	@Override
	public String toString() {
		return "ProductEntity [productId=" + productId + ", productName=" + productName + ", productPrice="
				+ productPrice + "]";
	}


	public ProductEntity(int productId, String productName, int productPrice) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
	}
	
	
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
	public int getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}
	public List<UserEntity> getUser() {
		return user;
	}
	public void setUser(List<UserEntity> user) {
		this.user = user;
	}
	


}
