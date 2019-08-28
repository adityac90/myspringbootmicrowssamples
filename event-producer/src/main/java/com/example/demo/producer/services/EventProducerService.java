package com.example.demo.producer.services;

import com.example.demo.producer.model.CustomEvent;

public interface EventProducerService {

    CustomEvent saveAEvent(CustomEvent event);

}
