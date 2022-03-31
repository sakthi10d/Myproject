package com.example.webclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.webclient.dao.ClientDao;
import com.example.webclient.service.ClientServerService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class ClientController {

	@Autowired
	ClientServerService clientServerService;

	@GetMapping("/webclient")
	public Flux<ClientDao> getStudentDetails(){
		return clientServerService.getStudents();
	}

	@GetMapping("/web1/{studentId}")
	public Mono<ClientDao>getStudentDetailsById(@PathVariable Integer studentId){
		return clientServerService.getStudentById(studentId);
	}
	
}
