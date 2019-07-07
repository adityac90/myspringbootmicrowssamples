package com.example.microservices.httpclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@FeignClient(value = "tweetapp-ws", fallback = TweetFallback.class)
public interface TweetClient {
    @GetMapping(value = "/tweets/getTweetss")
    public List<String> getTweets();
}

@Component
class TweetFallback implements TweetClient {
    @Override
    public List<String> getTweets() {
        return Stream.of("Dummy Tweet", "Dummy Tweet 2").collect(Collectors.toList());
    }
}
