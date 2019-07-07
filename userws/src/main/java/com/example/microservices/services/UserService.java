package com.example.microservices.services;

import com.example.microservices.ui.models.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    UserDto createUser(UserDto userDto);

    UserDto getUserDetailsByUserName(String userName);
}
