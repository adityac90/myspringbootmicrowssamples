package com.example.demo.eventconsumer.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CustomEvent {
    private long eventId;
    private String eventName;
    private String eventDescription;
}
