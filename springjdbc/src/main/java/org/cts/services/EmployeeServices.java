package org.cts.services;

import org.cts.models.Employee;

import java.util.List;


public interface EmployeeServices {
    public Boolean createEmployee(Employee employee);

    public List<Employee> getEmployeeDetails();

}
