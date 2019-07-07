package com.example.demo.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class Springmicroservicesexample1Application {

	public static void main(String[] args) {
		SpringApplication.run(Springmicroservicesexample1Application.class, args);
	}

}
