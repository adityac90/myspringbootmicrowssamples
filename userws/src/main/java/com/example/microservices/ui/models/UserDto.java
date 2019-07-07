package com.example.microservices.ui.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor
@Getter
@Setter
public class UserDto implements Serializable {
    private static final long SerialVersionUID = -98989898710l;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String userId;
    private String ecPassword;

}
