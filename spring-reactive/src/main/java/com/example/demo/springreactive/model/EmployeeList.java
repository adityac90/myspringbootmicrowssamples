package com.example.demo.springreactive.model;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EmployeeList {
    private List<Employee> employeeList;
}
