package com.example.demo.auth.services.impl;

import com.example.demo.auth.dao.UserRepository;
import com.example.demo.auth.model.User;
import com.example.demo.auth.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User finduUserByEmail(String email) {
        User byEmailID = userRepository.findByEmailID(email);
        if (byEmailID == null) {
            throw new UsernameNotFoundException(email);
        }
        return byEmailID;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User byEmailID = userRepository.findByEmailID(s);
        if (byEmailID == null) {
            throw new UsernameNotFoundException(s);
        }
        final org.springframework.security.core.userdetails.User user = new org.springframework.security.core.userdetails.User(byEmailID.getEmailID(), byEmailID.getPassword(), true, true, true, true, new ArrayList<>());
        return user;
    }
}
