package com.example.rabbitmqpro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RabbitMqProApplication {

	public static void main(String[] args) {
		SpringApplication.run(RabbitMqProApplication.class, args);
		System.out.println("producer");
	}

}
