package com.example.webclient.confg;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebclientConfig {

	@Bean
	public WebClient webClient() {
		WebClient webClient = WebClient 
				.builder()
				.baseUrl("http://localhost:8080")
				.defaultCookie("cookieKey", "cookieValue")
				.defaultHeader(org.springframework.http.HttpHeaders.CONTENT_TYPE,MediaType.APPLICATION_JSON_VALUE)
				.build();
		return webClient;
		
	}
}
