package com.example.demo;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }


}

@RestController
class DummyController {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping(value = "/api/v1/employees", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Employee> getEmployeeDetails() {
        System.out.println("Inside getEmployeeDetails ");
        Employee e1 = new Employee("1", "xx", "yy", "zz", "");
        Employee e2 = new Employee("2", "abc", "def", "jhuu", "");
        List<Employee> empList = new ArrayList<>();
        empList.add(e1);
        empList.add(e2);
        return empList;
    }
}

@Configuration
class JavaConfig {
    @Bean
    public RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        List<HttpMessageConverter<?>> converters =
                new ArrayList<HttpMessageConverter<?>>();
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
        converters.add(converter);
        restTemplate.setMessageConverters(converters);
        return restTemplate;
    }
}

class Employee implements Serializable {

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

    public Employee() {
    }

    public Employee(String empId, String empName, String empSalary, String empAge, String profileImage) {
        this.empId = empId;
        this.empName = empName;
        this.empSalary = empSalary;
        this.empAge = empAge;
        this.profileImage = profileImage;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpSalary() {
        return empSalary;
    }

    public void setEmpSalary(String empSalary) {
        this.empSalary = empSalary;
    }

    public String getEmpAge() {
        return empAge;
    }

    public void setEmpAge(String empAge) {
        this.empAge = empAge;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId='" + empId + '\'' +
                ", empName='" + empName + '\'' +
                ", empSalary='" + empSalary + '\'' +
                ", empAge='" + empAge + '\'' +
                ", profileImage='" + profileImage + '\'' +
                '}';
    }
}

class EmployeeList implements Serializable {
    @JsonProperty("employee")
    private List<Employee> employeeList;

    public EmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public EmployeeList() {
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    @Override
    public String toString() {
        return "EmployeeList{" +
                "employeeList=" + employeeList +
                '}';
    }
}