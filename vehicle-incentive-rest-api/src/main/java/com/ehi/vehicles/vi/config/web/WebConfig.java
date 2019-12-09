package com.ehi.vehicles.vi.config.web;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
public class WebConfig {
    @Bean
    public RestTemplate configureRestTemplate() {
        final RestTemplate restTemplate = new RestTemplate();
        restTemplate.setRequestFactory(clientHttpRequestFactory());
        return restTemplate;
    }

    @Bean
    public ClientHttpRequestFactory clientHttpRequestFactory() {
        HttpComponentsClientHttpRequestFactory clientFactory = new HttpComponentsClientHttpRequestFactory();
        clientFactory.setHttpClient(httpClient());
        clientFactory.setConnectTimeout(10000); // 10 seconds until connection with server is established
        clientFactory.setReadTimeout(120000); // 120 seconds to read data after connection is established
        return clientFactory;
    }

    @Bean
    public HttpClient httpClient() {
        HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
        httpClientBuilder.setConnectionManager(new PoolingHttpClientConnectionManager());
        httpClientBuilder.setMaxConnTotal(1000);
        httpClientBuilder.setMaxConnPerRoute(1000);
        return httpClientBuilder.build();
    }
}
