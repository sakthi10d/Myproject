package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Integer> {

	//Optional<UserEntity> findByMobileNum(String mobileNum);
	/* @Query("SELECT f FROM UserEntity f WHERE f.mobileNum = :mobileNum")
   Optional<UserEntity> getDetailsByPhoneNum(@Param("mobileNo")Long mobileNum);*/



	Optional<UserEntity> getDetailsByMobileNum(Long mobileNum);

	

}
