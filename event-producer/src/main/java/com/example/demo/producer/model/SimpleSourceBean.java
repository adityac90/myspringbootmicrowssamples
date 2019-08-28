package com.example.demo.producer.model;

import com.example.demo.producer.channels.CustomChannels;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
public class SimpleSourceBean {

    private Source source;
    @Autowired
    private CustomChannels cc;

    private static final Logger logger =
            LoggerFactory.getLogger(SimpleSourceBean.class);

    @Autowired
    public SimpleSourceBean(Source source) {
        this.source = source;
    }

    public void publishOrgChange(String action, String eventID, CustomEvent event) {
        logger.debug("Sending message to rabbit mesasge queue for action " + action + " and event ID=" + eventID);
        System.out.println("Sending message to rabbit mesasge queue for action " + action + " and event ID=" + eventID);

        source.output().send(MessageBuilder.withPayload(event).build());
        System.out.println("Before Sending data to custom channel");
        cc.customChannel().send(MessageBuilder.withPayload(event).build());
        System.out.println("After Sending data to custom channel");

    }

}
