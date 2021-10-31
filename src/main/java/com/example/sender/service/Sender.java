package com.example.sender.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import com.example.EntityDTO;

@Service
public class Sender {

	@Autowired
	JmsTemplate jmsTemplate;
	
	@Value("${jms.queue01}")
	String jmsQueue01;
	
	@Value("${jms.queue02}")
	String jmsQueue02;
	
	public void sendText(String message) {
		jmsTemplate.convertAndSend(jmsQueue01, message);
	}
	
	public void sendObject(EntityDTO object) {
		jmsTemplate.convertAndSend(jmsQueue02, object);
	}

}
