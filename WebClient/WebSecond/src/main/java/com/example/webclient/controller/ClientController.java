package com.example.webclient.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.webclient.entity.StudentEntity;
import com.example.webclient.service.StudentService;

@RestController
public class ClientController {

	
	@Autowired
    StudentService service;
	
	@GetMapping("/webclient2")
	public List<StudentEntity>getStudentDetail(){
		return service.getStudentDetails(); 
	}
	
	@GetMapping("/web/{studentId}")
	public Optional<StudentEntity>getStudentDetailsById(@PathVariable int studentId){
		return service.getStudentById(studentId);
	}
	
}
