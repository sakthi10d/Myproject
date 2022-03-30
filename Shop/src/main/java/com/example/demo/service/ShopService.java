package com.example.demo.service;



import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.bussinessexception.BussinessException;
import com.example.demo.bussinessexception.BussinessExceptionEnum;
import com.example.demo.entity.Things;
import com.example.demo.repository.ShopRepository;

@Service
public class ShopService {
	@Autowired
	ShopRepository repos;

	public  List<Things> getShopDetails() {

		return repos.findAll();
	}

	public  String getShopDetailsById(Integer productId) throws BussinessException{
		if (repos.existsById(productId)) {
			repos.getById(productId);
			return "successful";
		}
		throw new BussinessException(BussinessExceptionEnum.ID_NOT_FOUND.name(),BussinessExceptionEnum.ID_NOT_FOUND);
	}
	public String insertThings(List<Things>entity) {

		repos.saveAll(entity);
		return "inserted successfully";	
	}
	@Transactional
	public String deleteThingsByName(String productName) {
		repos.deleteByProductName(productName);
		return "Deleted successfull";
	}
	public String updatethings(List<Things>entity) {
		repos.saveAll(entity);
		return "Updated successfully";
	}

	public Things getThingsByProductPrice(Integer productPrice) throws BussinessException{

		if(repos.existsByProductPrice(productPrice)) {

		}
		else {
			throw new BussinessException(BussinessExceptionEnum.PRODUCT_NOT_FOUND.name(),BussinessExceptionEnum.PRODUCT_NOT_FOUND);
		}
		return repos.getByproductPrice(productPrice);
	}
}
