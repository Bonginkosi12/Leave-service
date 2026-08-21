package com.bonginkosi.leave_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
public class LeaveServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(LeaveServiceApplication.class, args);
	}

}
