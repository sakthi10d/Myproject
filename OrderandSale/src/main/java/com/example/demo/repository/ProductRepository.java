package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.ProductEntity;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity,Integer> {

	Optional<ProductEntity> getDetailsByProductName(String productName);

    Optional<ProductEntity> findByProductPrice(Integer productPrice);









}
