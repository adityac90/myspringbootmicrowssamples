package com.demo.microws;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class TweetappWsApplication {

	public static void main(String[] args) {
		SpringApplication.run(TweetappWsApplication.class, args);
	}

}
