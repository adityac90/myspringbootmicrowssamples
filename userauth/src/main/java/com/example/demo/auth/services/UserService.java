package com.example.demo.auth.services;

import com.example.demo.auth.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    User saveUser(User user);

    User finduUserByEmail(String email);
}
