package com.example.demo.springreactive.controllers;

import com.example.demo.springreactive.model.Employee;
import com.example.demo.springreactive.model.EmployeeList;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class MyAsyncController {
    private WebClient webClient = WebClient.builder().baseUrl("http://localhost:8083").defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE).build();

    @GetMapping(value = "/employees", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<EmployeeList> getEmployeeDetails() {
        Flux<EmployeeList> employeeListFlux = webClient.get().uri("/api/v1/employees").exchange()
                .flatMapMany(r -> r.bodyToFlux(EmployeeList.class));
        employeeListFlux.subscribe(emp -> System.out.println(emp));
        return employeeListFlux;
    }
    @GetMapping("employee/{id}")
    public Mono<Employee> getEmployee(@PathVariable String id){
        Flux<Object> aaaa = webClient.get().uri("/api/v1/employees").exchange().thenMany(e -> Flux.just("aaaa"));

    }

}
