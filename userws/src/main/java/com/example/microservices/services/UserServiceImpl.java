package com.example.microservices.services;

import com.example.microservices.data.UserEntity;
import com.example.microservices.data.UserRepository;
import com.example.microservices.ui.models.UserDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDto createUser(UserDto userDto) {
        userDto.setUserId(UUID.randomUUID().toString());
        userDto.setEcPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));
        UserEntity userEntity = modelMapper.map(userDto, UserEntity.class);
        userRepository.save(userEntity);
        UserDto createdUser = modelMapper.map(userEntity, UserDto.class);
        return createdUser;
    }

    @Override
    public UserDto getUserDetailsByUserName(String userName) {
        UserEntity userEntity = userRepository.findByEmail(userName);
        if (userEntity == null) {
            throw new UsernameNotFoundException(userName);
        }
        UserDto userFound = modelMapper.map(userEntity, UserDto.class);
        return userFound;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        //I can call third party web services to get user info from here
        //Here we are getting the details from DB
        UserEntity userEntity = userRepository.findByEmail(s);
        if (userEntity == null) {
            throw new UsernameNotFoundException(s);
        }
        //Spring provided User Object
        return new User(userEntity.getEmail(), userEntity.getEcPassword(), true, true, true, true, new ArrayList<>());
    }
}
