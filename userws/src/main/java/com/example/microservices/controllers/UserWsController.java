package com.example.microservices.controllers;


import com.example.microservices.httpclients.TweetClient;
import com.example.microservices.services.UserService;
import com.example.microservices.ui.models.CreateUserModel;
import com.example.microservices.ui.models.UserDto;
import com.example.microservices.ui.models.UserResponseModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@RestController
public class UserWsController {
    @Autowired
    private Environment environment;
    @Autowired
    private TweetClient tweetClient;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private UserService userService;

    @GetMapping("/status/check")
    public String status() {
        String myProperty = environment.getProperty("myProperty") != null ? "BHUTAI" : "ADITYA";
        List<String> tweets = tweetClient.getTweets();
        Optional<String> concatenatedTweets = tweets.stream().reduce((s, s2) -> s + s2);
        return "Working fine " + myProperty + concatenatedTweets.get();
    }

    @GetMapping("/demo")
    public String demo() {
        return "Hello World";
    }

    @PostMapping("/users")
    public ResponseEntity<UserResponseModel> createUser(@Valid @RequestBody CreateUserModel createUserModel) {
        UserDto userDto = modelMapper.map(createUserModel, UserDto.class);
        UserDto createdUser = userService.createUser(userDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(modelMapper.map(createdUser, UserResponseModel.class));
    }
}
