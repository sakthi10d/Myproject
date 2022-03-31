package com.example.webclient.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.webclient.Repository.StudentRepository;
import com.example.webclient.entity.StudentEntity;

@Service
public class StudentService {

	@Autowired
	StudentRepository student;

	public List<StudentEntity> getStudentDetails() {
		return student.findAll();
	}

	public Optional<StudentEntity> getStudentById(int studentId){
		return student.findById(studentId);
	}
	
	
}
