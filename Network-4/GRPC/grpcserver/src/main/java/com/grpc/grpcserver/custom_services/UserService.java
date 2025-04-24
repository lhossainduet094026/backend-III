package com.grpc.grpcserver.custom_services;

import com.grpc.grpcserver.service.UserRequest;
import com.grpc.grpcserver.service.UserResponse;
import com.grpc.grpcserver.service.UserServiceGrpc;

import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.server.service.GrpcService;

@Slf4j
@GrpcService
public class UserService extends UserServiceGrpc.UserServiceImplBase {

	@Override
	public void getUser(UserRequest request, StreamObserver<UserResponse> responseObserver) {

		log.info("userId :{}", request.getUserId());

		UserResponse userResponse = UserResponse.newBuilder().setName("micheal").setAge(80).build();

		responseObserver.onNext(userResponse);

		responseObserver.onCompleted();
	}
}
