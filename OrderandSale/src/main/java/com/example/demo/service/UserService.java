package com.example.demo.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.ProductEntity;
import com.example.demo.entity.UserEntity;
import com.example.demo.repository.ProductRepository;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {
	 
	@Autowired
	UserRepository userRepository;
	@Autowired
	ProductRepository productRepository;
	 
	
	public UserEntity insertUserDetails(UserEntity user) {
		 return userRepository.save(user);
	}
	public ProductEntity insertProductDetails(ProductEntity product) {
		return productRepository.save(product);
	}
	
	
	
	public List<ProductEntity>getproductDetails(){
		return productRepository.findAll();
	}
	public List<UserEntity>getuserDetails(){
		return userRepository.findAll();
	}
	public UserEntity getUserById(Integer userId) {
		return userRepository.findById(userId).get();
	}
	
	
	
	public String placeOrderByUserAndProduct(Long mobileNum,String productName) {
	
		Optional<UserEntity> useopt = userRepository.getDetailsByMobileNum(mobileNum);
		Optional<ProductEntity> proopt = productRepository.getDetailsByProductName(productName);
		 
		if (useopt.isPresent()&& proopt.isPresent() ) {

			UserEntity userEntity = useopt.get();
			ProductEntity productEntity = proopt.get();
			
			List<ProductEntity>prolist = userEntity.getProduct();
			List<UserEntity>usrList=productEntity.getUser();
			prolist.add(productEntity);
			usrList.add(userEntity);
		     
			userEntity.setProduct(prolist);
			productRepository.save(productEntity);
			
			productEntity.setUser(usrList);
	        userRepository.save(userEntity);		
			
	        
		}
		else {
			
		}	
		return "mapped successfully";
	}
	 
	
	
	
	
	
	public List<UserEntity> getUsersByProductsName(String productName) {
		Optional<ProductEntity>prooptt = productRepository.getDetailsByProductName(productName);
	   if (prooptt.isPresent()) {
			 return  prooptt.get().getUser();
			
		}
	   return null;
	}
	
	public List<UserEntity>getUserByProductPrice(Integer productPrice){
		Optional<ProductEntity>prooopt = productRepository.findByProductPrice(productPrice);
		if (prooopt.isPresent()) {
			List<UserEntity> userEntity =  prooopt.get().getUser();
			return userEntity;
		}
		return null;
	}
	
	
	 
	public String eraseAllUsers() {
		userRepository.deleteAll();
		return "deleted Successfully";
	
	}
	
	
	
	
	
}
	
	
	