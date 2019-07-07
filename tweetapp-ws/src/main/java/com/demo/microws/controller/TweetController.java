package com.demo.microws.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TweetController {
    @GetMapping(value = "/tweets/getTweets", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<String> getTweets() {
        List<String> tweetList = new ArrayList<>();
        tweetList.add("India Wins vs Pakistan !! what a match");
        tweetList.add("Rahul gandhi quits as a UPA president");
        tweetList.add("#indiawinswc19 #feelingproud");
        tweetList.add("#gogreen #globalwarming #plantatree #saveourearth");
        return tweetList;

    }


}
