package com.example.demo.eventconsumer.channel;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface CustomChannels {
    @Input("customInputChannel")
    SubscribableChannel inputChannel();
}
