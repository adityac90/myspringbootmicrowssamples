package com.example.demo.producer.services.impl;

import com.example.demo.producer.model.CustomEvent;
import com.example.demo.producer.model.SimpleSourceBean;
import com.example.demo.producer.repository.EventProducerRepository;
import com.example.demo.producer.services.EventProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventProducerServiceImpl implements EventProducerService {
    @Autowired
    private EventProducerRepository eventProducerRepository;
    @Autowired
    private SimpleSourceBean simpleSourceBean;

    @Override
    public CustomEvent saveAEvent(CustomEvent event) {
        CustomEvent savedEvent = eventProducerRepository.save(event);
        simpleSourceBean.publishOrgChange("save", String.valueOf(savedEvent.getEventId()), savedEvent);
        return savedEvent;
    }
}
