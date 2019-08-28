package com.example.demo.producer.channels;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;


public interface CustomChannels {
    @Output("customOutputChannel")
    MessageChannel customChannel();
}
