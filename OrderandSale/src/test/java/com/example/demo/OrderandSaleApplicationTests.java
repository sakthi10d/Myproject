package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.entity.ProductEntity;
import com.example.demo.entity.UserEntity;
import com.example.demo.service.UserService;

@SpringBootTest
@RunWith(SpringRunner.class)
class OrderandSaleApplicationTests {


	@MockBean
	UserService userService;

	@Test
	void contextLoads() {
	}

	@Test
	void getuserDetails() {
		List<UserEntity> list = new ArrayList<>();
		list.add(new UserEntity(1, "sakthi", "sakthi123", 987655443l));
		list.add(new UserEntity(2, "jeeva", "jeeva123", 97881l));

		Mockito.when(userService.getuserDetails()).thenReturn(list);

		List<UserEntity> expected = userService.getuserDetails();
		System.out.println(expected.toString());
		assertEquals(expected,list);
	}

	@Test
	void insertUserDetails() {
		UserEntity userEntity = new UserEntity(1, "Sakthigv", "Sakthigv1298", 9788159636l);
		Mockito.when(userService.insertUserDetails(userEntity)).thenReturn(userEntity);
		UserEntity expected = userService.insertUserDetails(userEntity);
		assertEquals(expected,userEntity);

	}


	@Test
	public void getUserbyIdTest() {
		int id = 1;
		UserEntity userEntity = new UserEntity(id, "sakthi", "sakthi123", 12344l);
		
		Mockito.when(userService.getUserById(id)).thenReturn(userEntity);

		UserEntity expected = userService.getUserById(id);
		System.out.println(expected);
		assertEquals(expected,userEntity);
	}
	
	@Test
	 void getProductDetails() {
		List<ProductEntity> productEntity = new ArrayList<>();
		productEntity.add(new ProductEntity(1, "bike", 100000));
		productEntity.add(new ProductEntity(2,"television",50000));
		productEntity.add(new ProductEntity(3, "car", 10000000));
		
		Mockito.when(userService.getproductDetails()).thenReturn(productEntity);
		List<ProductEntity> expected = userService.getproductDetails();
		System.out.println(expected);
		assertEquals(expected, productEntity);	
	}
	
	@Test
	void insertProductDetails() {
		ProductEntity productEntity = new ProductEntity(1, "computer",100000);
		System.out.println("productEntity"+" "+productEntity);
		Mockito.when(userService.insertProductDetails(productEntity)).thenReturn(productEntity);
		ProductEntity expected = userService.insertProductDetails(productEntity);
		System.out.println("expected");
		System.out.println(expected);
		assertEquals(expected, productEntity);
		
	}
	
	@Test
	void placeOrder() {
		 long mobileNum = 1232345656l;
		 String productName = "laptop";
		 
		 Mockito.when(userService.placeOrderByUserAndProduct(mobileNum, productName)).thenReturn("mapped successfully");
		 String expected = userService.placeOrderByUserAndProduct(mobileNum, productName);
		 assertEquals(expected, "mapped successfully");
		 
	}
  
   @Test
   void getUsersByProducts() {
	   List<UserEntity> userEntity = new ArrayList<>();
	   userEntity.add(new UserEntity(1, "sakthi","sakthigv", 12345l));
	   userEntity.add(new UserEntity(2, "jeeva", "jeeva123", 2345465l));
	   userEntity.add(new UserEntity(3, "prakash","prakash123", 1223344l));
	   
	   String productName = "Shirt";
	   
	   Mockito.when(userService.getUsersByProductsName(productName)).thenReturn(userEntity);
	   List<UserEntity> expected = userService.getUsersByProductsName(productName);
	   assertEquals(expected, userEntity);
	   }
      
   @Test
   void getUserByProductPrice() {
	   List<UserEntity> userEntity = new ArrayList<>();
	   userEntity.add(new UserEntity(1, "sakthi","sakthigv", 12345l));
	   userEntity.add(new UserEntity(2, "jeeva", "jeeva123", 2345465l));
	   userEntity.add(new UserEntity(3, "prakash","prakash123", 1223344l));
	   
	   int productPrice = 10000;
	   
	   Mockito.when(userService.getUserByProductPrice(productPrice)).thenReturn(userEntity);
	   List<UserEntity> expected = userService.getUserByProductPrice(productPrice);	
	   assertEquals(expected,userEntity);
	   
   }
      
   @Test
   void deleteAllUsers() {
	  // UserEntity userEntity = new UserEntity(1, "sakthi", "sakthi123", 122344l);new UserEntity(2, "sakthi1", "sakthi1234", 45567l);
	   
	   Mockito.when(userService.eraseAllUsers()).thenReturn("deleted Succesfully");
	   
	//	String Expected = userService.eraseAllUsers();
    //  String Expect  = userService.eraseAllUsers();
		
		verify(userService, times(0)).eraseAllUsers();
	}
   



}