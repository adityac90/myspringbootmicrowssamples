package com.example.microservices.errordecoders;

import feign.Response;
import feign.codec.ErrorDecoder;
import org.springframework.stereotype.Component;
//Comment component to test hystrix is working or  not
/*@Component*/
public class FeignErrorDecoder implements ErrorDecoder {
    @Override
    public Exception decode(String s, Response response) {
        return new RuntimeException("Eror from my custom Error Decoder");
    }
}
