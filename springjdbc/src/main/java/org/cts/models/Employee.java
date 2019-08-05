package org.cts.models;

import org.springframework.stereotype.Component;

@Component
public class Employee {
    private String employeeID;
    private String employeeName;
    private String address;
    private String designationl;
    private String department;

    public Employee() {
    }

    public Employee(String employeeID, String employeeName, String address, String designationl, String department) {
        this.employeeID = employeeID;
        this.employeeName = employeeName;
        this.address = address;
        this.designationl = designationl;
        this.department = department;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDesignationl() {
        return designationl;
    }

    public void setDesignationl(String designationl) {
        this.designationl = designationl;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeID='" + employeeID + '\'' +
                ", employeeName='" + employeeName + '\'' +
                ", address='" + address + '\'' +
                ", designationl='" + designationl + '\'' +
                ", department='" + department + '\'' +
                '}';
    }
}
