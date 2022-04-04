package com.example.rabbitmqConsu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RabbitMqConsuApplication {

	public static void main(String[] args) {
		SpringApplication.run(RabbitMqConsuApplication.class, args);
	    System.out.println("Consumer");
	}

}
