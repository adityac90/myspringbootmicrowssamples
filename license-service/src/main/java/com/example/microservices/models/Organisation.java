package com.example.microservices.models;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Organisation {
    private String ordId;
    private String orgName;
    private long totalEmployeeStrength;
    private String headQuaters;
}
