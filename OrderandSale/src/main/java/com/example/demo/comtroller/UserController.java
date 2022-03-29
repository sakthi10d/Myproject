
package com.example.demo.comtroller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.ProductEntity;
import com.example.demo.entity.UserEntity;
import com.example.demo.service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService service;

	
	
	@GetMapping("/userretrive")
	public List<UserEntity> getUser(){
		return service.getuserDetails();
	}

	@PostMapping("/user")
	public void insertuserDetails(@RequestBody  UserEntity user) {
		service.insertUserDetails(user);
	}
	
	
	@GetMapping("/productretrive")
	public List<ProductEntity>getProducts(){
		return service.getproductDetails();
	}
	
	@PostMapping("/product")
	public void insertProductDetails(@RequestBody ProductEntity product) {
		service.insertProductDetails(product);
	}
	
	@GetMapping("/use/{userId}")
	public UserEntity getById(Integer userId){
		return service.getUserById(userId);
	}
	
	@PostMapping("/placeorder")
	public String placeOrderByUserAndProduct(@RequestParam Long mobileNum,@RequestParam String productName) {
		service.placeOrderByUserAndProduct(mobileNum, productName);
        return "mapped Successfully";
	}

	@GetMapping("/user_list/{productName}")
	public List<UserEntity> getUserByProduct(@PathVariable String productName) {
		return service.getUsersByProductsName(productName);
	}
	@GetMapping("/user_list/product/{productPrice}")
		public List<UserEntity> getUserByPrice(@PathVariable Integer productPrice){
		return service.getUserByProductPrice(productPrice);
	   //return null;
	}
	
	@DeleteMapping("/user/deleteall")
	public String eraseAllUserDetails() {
	 service.eraseAllUsers();
	 return "deleted Successfully";
	}
	
   }
