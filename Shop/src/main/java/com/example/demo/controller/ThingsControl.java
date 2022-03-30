package com.example.demo.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bussinessexception.BussinessException;
import com.example.demo.entity.Things;
import com.example.demo.service.ShopService;

@RestController
public class ThingsControl {
	@Autowired	
	ShopService service;
	@GetMapping("/product/version_1") 
	public List<Things> getShopDetails() 
	{
		return service.getShopDetails();
	}
	@GetMapping("/product/version_2/{productId}") 
	public String getShopDetails(@PathVariable Integer productId) throws BussinessException
	{
		service.getShopDetailsById(productId);
		return "successful";
	}
	@PostMapping("/product")
	public String insertThings(@RequestBody List<Things>entity) {
		return service.insertThings(entity);	
	}
	@DeleteMapping("/product/{productName}")
	public String deleteThingsByName(@PathVariable String productName) {

		return service.deleteThingsByName(productName);
	}
	@PutMapping("/product")
	public String updateThings(@RequestBody List<Things>entity) {
		return service.updatethings(entity);
	}
	@GetMapping("/price/{productPrice}")
	public Things  getProductByProductPrice(@PathVariable Integer productPrice) {
	   return	service.getThingsByProductPrice(productPrice);
	}

}
