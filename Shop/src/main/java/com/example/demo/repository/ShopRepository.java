package com.example.demo.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Things;

@Repository
public interface ShopRepository extends JpaRepository<Things,Integer> {

//	Things findByProductName(String productName);

	void deleteByProductName(String productName);

	Things findByProductId(Integer productId);

	Things getByproductPrice(Integer productPrice);

	boolean existsByProductPrice(Integer productPrice);

	

	
	



	
	
}
