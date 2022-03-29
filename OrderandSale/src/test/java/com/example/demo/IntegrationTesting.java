package com.example.demo;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.demo.entity.ProductEntity;
import com.example.demo.entity.UserEntity;

@SpringBootTest(classes = OrderandSaleApplication.class,webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class IntegrationTesting {

	
	@LocalServerPort
	private int port;
	
	@Autowired
	private TestRestTemplate restTemplate = new TestRestTemplate();


	HttpHeaders headers = new HttpHeaders();

	@Test
	public void getUserDetails() {
		System.out.println("getUserDetails");
		
		String url="http://localhost:"+port+"/userretrive";

		HttpEntity<String>entity=new HttpEntity<String>(null,headers);

		UriComponentsBuilder builder=UriComponentsBuilder.fromUriString(url);

		ResponseEntity<String> responseEntity = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity, String.class);
		System.out.println(responseEntity);
	}


	@Test
	public void insertUserDetails() {
		System.out.println("insertUserDetails");
		
		String url="http://localhost:"+port+"/user";
		
		UserEntity userEntity = new UserEntity(1, "sakthi", "sakthi12344", 9876543220l);
		
		HttpEntity<UserEntity>entity=new HttpEntity<UserEntity>(userEntity,headers);
		
		UriComponentsBuilder builder=UriComponentsBuilder.fromUriString(url);
		ResponseEntity<String> responseEntity = restTemplate.exchange(builder.toUriString(), HttpMethod.POST, entity, String.class);
		System.out.println(responseEntity);
	}

	@Test
	public void getProductdetails() {
		System.out.println("getProductdetails");
		
		String url = "http://localhost:"+port+"/productretrive";
		HttpEntity<String>entity = new HttpEntity<String>(null,headers);
		UriComponentsBuilder builder  = UriComponentsBuilder.fromUriString(url);
		ResponseEntity<String> responseEntity = restTemplate.exchange(builder.toUriString(), HttpMethod.GET,entity,String.class);
		System.out.println(responseEntity);  
	}


	@Test
	public void insertProductDetails() {
	    System.out.println("insertProductDetails");
		
		ProductEntity productEntity = new ProductEntity(1, "shirt", 1000);
		String url = "http://localhost:"+port+"/product";
		HttpEntity<ProductEntity>entity = new HttpEntity<ProductEntity>(productEntity,headers);
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url);
		ResponseEntity<String> responseEntity = restTemplate.exchange(builder.toUriString(),HttpMethod.POST,entity,String.class);
		System.out.println(responseEntity);
	}

	@Test
	public void placeOrderByUserAndProduct() {
     
		System.out.println("placeOrderByUserAndProduct");
		
		Long ph=9876543220l;
		
		String url = "http://localhost:"+port+"/placeorder?mobileNum="+ph+"&productName=shirt";
		HttpEntity<String>entity = new HttpEntity<String>(null,null);
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url);
		ResponseEntity<String> responseEntity = restTemplate.exchange(builder.toUriString(),HttpMethod.POST,entity,String.class);
		System.out.println(responseEntity);
	}
	
	
	@Test
	public void getUserByProductName() {
		System.out.println("getUserByProductName");
		
		String productName = "shirt"; 
		
		String url = "http://localhost:"+port+"/user_list/"+productName;
		HttpEntity<UserEntity> entity = new HttpEntity<UserEntity>(null,headers);
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url);
		ResponseEntity<String> responseEntity = restTemplate.exchange(builder.toUriString(),HttpMethod.GET,entity,String.class);
		System.out.println(responseEntity);
	}

	@Test
	public void getUserByProductPrice() {
		System.out.println("getUserByProductPrice");
		
		int productPrice = 1000;
		
		String url = "http://localhost:"+port+"/user_list/product/"+productPrice;
		HttpEntity<UserEntity>entity = new HttpEntity<UserEntity>(null,headers);
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url);
		ResponseEntity<String>response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET,entity,String.class);
		System.out.println(response);
		
	}
}


