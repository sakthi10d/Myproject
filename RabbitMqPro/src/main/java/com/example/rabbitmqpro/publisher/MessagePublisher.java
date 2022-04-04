package com.example.rabbitmqpro.publisher;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.rabbitmqpro.configuration.MQConfig;
import com.example.rabbitmqpro.model.CustomMessage;

@RestController
public class MessagePublisher {

	@Autowired
	private RabbitTemplate template;

	@PostMapping("/publish")
	public String publishMessage(@RequestBody CustomMessage message) {
		template.convertAndSend(MQConfig.EXCHANGE,
				MQConfig.ROUTING_KEY, message);
		System.out.println(message);

		return "Message Published";
	}
}
