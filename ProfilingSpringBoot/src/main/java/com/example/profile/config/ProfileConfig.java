package com.example.profile.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@ConfigurationProperties(value = "spring.datasource")
@SuppressWarnings("unused")
public class ProfileConfig {
	@Value("${spring.datasource.driver-class-name}")	
	private String driverClass;
	@Value("${spring.datasource.url}")	
	private String url;
	@Value("${spring.datasource.username}")
	private String username;
	@Value("${spring.datasource.password}")
	private String password;

	@Profile("dev")
	@Bean
	public String devDatabaseConnection() {
		System.out.println(driverClass);
		System.out.println(url);
		System.out.println(username);
		System.out.println(password);
		return "Dev Database";
	}
	@Profile("tests")
	@Bean
	public String testDatabaseConnection1() {
		System.out.println(driverClass);
		System.out.println(url);
		System.out.println(username);
		System.out.println(password);
		return "test Database";
	}
	@Profile("prod")
	@Bean
	public String ProdDatabaseConnection() {
		System.out.println(driverClass);
		System.out.println(url);
		System.out.println(username);
		System.out.println(password);
		return "Production Database";
	}








}
