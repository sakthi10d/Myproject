package com.example.rabbitmqConsu.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.rabbitmqConsu.entity.CustomMessage;

public interface CustomerRepo extends JpaRepository<CustomMessage, Integer> {

}
