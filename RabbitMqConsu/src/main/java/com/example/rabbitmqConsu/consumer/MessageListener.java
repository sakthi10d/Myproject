package com.example.rabbitmqConsu.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.rabbitmqConsu.configu.MQConfig;
import com.example.rabbitmqConsu.entity.CustomMessage;
import com.example.rabbitmqConsu.repo.CustomerRepo;

@Component
public class MessageListener {

	@Autowired
	CustomerRepo customerRepo;
	
    @RabbitListener(queues = MQConfig.QUEUE)
    public void listener(CustomMessage message) {
        System.out.println(message);
        customerRepo.save(message);
    }

}
