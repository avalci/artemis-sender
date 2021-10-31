package com.example.sender.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.EntityDTO;
import com.example.sender.service.Sender;

@RestController
public class SenderController {

	@Autowired
	private Sender sender;

	@GetMapping("text")
	public ResponseEntity<String> send(@RequestBody String text) {
		sender.sendText(text);
		return new ResponseEntity<>("Text sent: " + text, HttpStatus.OK);
	}
	// curl -s -d "Text" -H "Content-Type: text/plain" -X GET http://localhost:8080/text

	@PostMapping("object")
	public ResponseEntity<EntityDTO> cadastrar(@RequestBody EntityDTO object, UriComponentsBuilder uriBuilder) {
		sender.sendObject(object);
		URI uri = uriBuilder.path("/object/{id}").buildAndExpand(object.getId()).toUri();
		return ResponseEntity.created(uri).body(object);
	}
	// curl -s -d '{"id":1,"name":"Test","type":"TWO"}' -H "Content-Type: application/json" -X POST http://localhost:8080/object
}
