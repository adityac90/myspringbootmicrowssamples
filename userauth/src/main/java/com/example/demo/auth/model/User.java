package com.example.demo.auth.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Component
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "USER_DETAIL", schema = "testDB")
public class User {
    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO,
            generator = "native"
    )
    @GenericGenerator(
            name = "native",
            strategy = "native"
    )
    @Column(name = "user_id", nullable = false)
    private long user_id;
    @JsonProperty("email")
    @Column(name = "email")
    private String email;
    @Column(name = "user_name")
    @JsonProperty("username")
    private String user_name;
    @Column(name = "password")
    @JsonProperty("pwd")
    private String password;
    @Column(name = "date_of_birth")
    @JsonProperty("dob")
    private String date_of_birth;
}
