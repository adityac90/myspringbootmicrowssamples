package com.example.demo.eventconsumer;

import com.example.demo.eventconsumer.channel.CustomChannels;
import com.example.demo.eventconsumer.model.CustomEvent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

@SpringBootApplication
@EnableDiscoveryClient
@EnableCircuitBreaker
@EnableBinding({Sink.class, CustomChannels.class})
public class EventConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(EventConsumerApplication.class, args);
    }

    @StreamListener(Sink.INPUT)
    public void eventListener(CustomEvent event) {
        System.out.println("receieved message for event --> " + event);


    }

    @StreamListener("customInputChannel")
    public void anotherEventListener(CustomEvent event) {
        System.out.println("In My custom channel ########## receieved message for event --> " + event);


    }

}
