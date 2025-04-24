package com.grpc.client.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.grpc.client.service.UserServiceGrpc;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import jakarta.annotation.PreDestroy;

@Configuration
public class GrpcClientConfig {

	@Bean
	public ManagedChannel userServiceChannel() {
		return ManagedChannelBuilder.forAddress("localhost", 8000).usePlaintext() // Matches negotiation-type=plaintext
				.build();
	}

	@Bean
	public UserServiceGrpc.UserServiceBlockingStub userServiceStub(ManagedChannel channel) {
		return UserServiceGrpc.newBlockingStub(channel);
	}
}
