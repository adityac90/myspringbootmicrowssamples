package com.example.microservices.feignerrordecoders;

import feign.Response;
import feign.codec.ErrorDecoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class FeignErrorDecoder implements ErrorDecoder {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public Exception decode(String s, Response response) {
        logger.error("Feing Excedption" + response.toString());
        return new Exception("Feign");
    }
}
