/**
 * 
 */
package com.example.demo.springboot.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.springboot.models.Transaction;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author aditya
 *
 */
@RestController
@EnableBinding(Source.class)
public class ProducerController {
	@Autowired
	Source source;

	@PostMapping("/txn")
	public String sendMessage(@RequestBody String payLoad) {
		ObjectMapper mapper = new ObjectMapper();
		Transaction txn = null;
		try {
			txn = mapper.readValue(payLoad, Transaction.class);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		source.output().send(MessageBuilder.withPayload(payLoad).setHeader("api-token", "ABC123456").build());
		System.out.println("Message sent successfully");
		return "Success";
	}

}
