package com.example.microservices.ui.models;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@NoArgsConstructor
@Getter
@Setter
public class CreateUserModel {
    @NotNull
    @Size(min = 2)
    private String firstName;
    @NotNull
    @Size(min = 4)
    private String lastName;
    @NotNull
    @Email
    private String email;
    @NotNull
    @Size(min = 4, max = 16)
    private String password;

}
