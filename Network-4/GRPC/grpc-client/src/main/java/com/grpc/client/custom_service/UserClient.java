package com.grpc.client.custom_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grpc.client.model.User;
import com.grpc.client.service.UserRequest;
import com.grpc.client.service.UserResponse;
import com.grpc.client.service.UserServiceGrpc;

import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.client.inject.GrpcClient;

@Slf4j
@Service
public class UserClient {

	private UserServiceGrpc.UserServiceBlockingStub userService;

	@Autowired
    public UserClient(UserServiceGrpc.UserServiceBlockingStub userService) {
        this.userService = userService;
    }

	public User getUser(int userId) {

		UserRequest userRequest = UserRequest.newBuilder().setUserId(userId).build();

		UserResponse userResponse = userService.getUser(userRequest);

		log.info("user Name :{}", userResponse.getName());
		log.info("user age :{}", userResponse.getAge());
		
		User user = new User();
		user.setName(userResponse.getName());
		user.setAge(userResponse.getAge());

		return user;
	}
}
