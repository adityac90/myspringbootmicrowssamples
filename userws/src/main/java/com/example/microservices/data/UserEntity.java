package com.example.microservices.data;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "users")
public class UserEntity implements Serializable {
    private static final long SerialVersionUID = -98989454598710l;
    @Id
    @GeneratedValue
    private long Id;
    @Column(name = "first_name", nullable = false)
    private String firstName;
    @Column(name = "last_name", nullable = false)
    private String lastName;
    @Column(name = "email", nullable = false, unique = true)
    private String email;
    @Column(name = "userID", nullable = false)
    private String userId;
    @Column(name = "ecPassword", nullable = false)
    private String ecPassword;
}
