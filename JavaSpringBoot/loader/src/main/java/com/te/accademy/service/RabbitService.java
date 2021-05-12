package com.te.accademy.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.accademy.config.MessagioRabbit;
import com.te.accademy.data.Data;

@Service
public class RabbitService {

	@Autowired
	private  RabbitTemplate rabbitTemplate;
	
	
	public void sendTestMessage(MessagioRabbit message) {
//		rabbitTemplate.convertAndSend("loader",message);
	}


	public void sendExcelMessage(Data data) {
		rabbitTemplate.convertAndSend("loader", data);
		
	}
}
