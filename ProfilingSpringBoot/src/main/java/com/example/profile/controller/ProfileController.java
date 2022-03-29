package com.example.profile.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/profile")
public class ProfileController {
	@Value("${spring.datasource.driver-class-name}")	
	private String driverClass;
	@Value("${spring.datasource.url}")	
	private String url;
	@Value("${spring.datasource.username}")
	private String username;
	@Value("${spring.datasource.password}")
	private String password;
	
	@Value("${app.message}")
	private String message;
	
	@GetMapping("/data")
	public String database() {
		return message+"--------"+driverClass+"---------"+url+"--------"+username+"------"+password;
	}

}

