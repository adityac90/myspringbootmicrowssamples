package com.example.demo.springboot;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

import com.example.demo.springboot.models.Transaction;

@EnableBinding(Sink.class)
public class MessageConsumer {
	@StreamListener(value = Sink.INPUT)
	public void logMessage(Transaction txn) {
		System.out.println("Message received with txn = " + txn);
	}

}
