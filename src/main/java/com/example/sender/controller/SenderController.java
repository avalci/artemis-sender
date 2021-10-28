package com.example.sender.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.sender.service.Sender;

@RestController
public class SenderController {

	@Autowired
	private Sender sender;
	
	@RequestMapping("send")
	public ResponseEntity<String> send(@RequestBody String message) {
		sender.sendMessage(message);
		return new ResponseEntity<>("Message sent: " + message, HttpStatus.OK);
	}
}
