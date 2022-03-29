package com.example.demo.entity;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.springframework.lang.NonNull;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity

public class UserEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Customer_Id")
	int userId;
	@Column(name = "User_Name", nullable = false)
	String userName;
	@Column (name = "Password",nullable = false)
	String password;
	@Column(name = "Mobile_Numbers",nullable = false,unique = true)
	@NonNull
	Long mobileNum;

	public UserEntity(int userId, String userName, String password, Long mobileNum) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.mobileNum = mobileNum;
	}
	@Override
	public String toString() {
		return "UserEntity [userId=" + userId + ", userName=" + userName + ", password=" + password + ", mobileNum="
				+ mobileNum + "]";
	}
	
	public UserEntity() {

	}
	
	@JsonIgnore
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "user_product",
	joinColumns = {@JoinColumn (name ="user_Id")},
	inverseJoinColumns = {@JoinColumn(name = "product_Id")})
	
	List<ProductEntity> product;
	


	public List<ProductEntity> getProduct() {
		return product;
	}

	public void setProduct(List<ProductEntity> product) {
		this.product = product;
	}

	public Long getMobileNum() {
		return mobileNum;
	}

	public void setMobileNum(Long mobileNum) {
		this.mobileNum = mobileNum;
	}

	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}


}


