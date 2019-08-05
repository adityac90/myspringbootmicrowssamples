package org.cts.services.impl;

import org.cts.dao.EmployeeDao;
import org.cts.models.Employee;
import org.cts.services.EmployeeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServicesImpl implements EmployeeServices {
    @Autowired
    EmployeeDao employeeDao;

    public Boolean createEmployee(Employee employee) {
        return employeeDao.saveEmployee(employee);
    }

    public List<Employee> getEmployeeDetails() {
        return employeeDao.fetchEmployeeDetails();
    }
}
