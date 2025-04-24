package com.grpc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class GrpcserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(GrpcserverApplication.class, args);
		 log.info("gRPC Server is Running... Waiting for Requests...");
	
//		 try {
//			Thread.currentThread().join();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

	 
}
