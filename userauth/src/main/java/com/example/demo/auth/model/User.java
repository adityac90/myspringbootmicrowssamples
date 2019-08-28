package com.example.demo.auth.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Component
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "USER_DETAIL")
public class User {
    @Id
    @GeneratedValue
    private long userId;
    @JsonProperty("email")
    private String emailID;
    @JsonProperty("username")
    private String userName;
    @JsonProperty("pwd")
    private String password;
    @JsonProperty("dob")
    private String dateOfBirth;
}
