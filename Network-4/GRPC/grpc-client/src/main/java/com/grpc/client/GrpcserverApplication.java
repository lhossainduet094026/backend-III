package com.grpc.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.grpc.client", "com.grpc.client.custom_service"})
public class GrpcserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(GrpcserverApplication.class, args);
		
//		try {
//			Thread.currentThread().join();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

}
