package com.example.demo.producer.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CustomEvent {
    @Id
    @GeneratedValue
    private long eventId;
    private String eventName;
    private String eventDescription;
}
