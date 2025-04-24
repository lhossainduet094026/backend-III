package com.grpc.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grpc.client.custom_service.UserClient;
import com.grpc.client.model.User;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/users")
public class UserController {

	private final UserClient client;

	@Autowired
	public UserController(UserClient userClient) {
		this.client = userClient;
	}

	@GetMapping("/{id}")
	public ResponseEntity<User> getUserById(@PathVariable("id") int id) {

		log.info("id :{}", id);
		User user = client.getUser(id);

		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
}
