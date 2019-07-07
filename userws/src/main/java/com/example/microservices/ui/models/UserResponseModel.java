package com.example.microservices.ui.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserResponseModel {
    private String firstName;
    private String lastName;
    private String email;
    private String userId;
}
