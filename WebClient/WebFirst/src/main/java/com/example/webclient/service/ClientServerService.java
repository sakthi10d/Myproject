package com.example.webclient.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.webclient.dao.ClientDao;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ClientServerService {

	@Autowired
	WebClient webClient;
	
	
	
	public Flux<ClientDao> getStudents(){
		return webClient.get()
				        .uri("/webclient2")
				        .retrieve()
				        .bodyToFlux(ClientDao.class);
				
	}
	
	public Mono<ClientDao>getStudentById(Integer studentId){
		return webClient.get() 
				        .uri("/web/{studentId}",studentId)
				        .retrieve()
				        .bodyToMono(ClientDao.class);
	}
}