package com.example.demo.springreactive.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@ToString
public class Employee {
    @JsonProperty("id")
    private String empId;
    @JsonProperty("employee_name")
    private String empName;
    @JsonProperty("employee_salary")
    private String empSalary;
    @JsonProperty("employee_age")
    private String empAge;
    @JsonProperty("profile_image")
    private String profileImage;

}
