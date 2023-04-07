package com.example.ms3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MotoService1Application {

	public static void main(String[] args) {
		SpringApplication.run(MotoService1Application.class, args);
	}

}
