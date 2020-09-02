package com.vi.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableEurekaServer
public class ViAppGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ViAppGatewayApplication.class, args);
	}

}
