package com.example.microservices.ui.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class LoginRequestModel {
    private String email;
    private String password;
}
