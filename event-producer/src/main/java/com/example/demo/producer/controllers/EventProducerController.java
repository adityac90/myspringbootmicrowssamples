package com.example.demo.producer.controllers;

import com.example.demo.producer.model.CustomEvent;
import com.example.demo.producer.services.EventProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EventProducerController {
    @Autowired
    private EventProducerService eventProducerService;

    @PostMapping("/saveEvent")
    public ResponseEntity<CustomEvent> saveAEvent(@RequestBody CustomEvent event) {
        return ResponseEntity.status(HttpStatus.OK).body(eventProducerService.saveAEvent(event));

    }

}
