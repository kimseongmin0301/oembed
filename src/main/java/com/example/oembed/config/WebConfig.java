package com.example.oembed.config;


import org.apache.commons.validator.routines.UrlValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebConfig {

    @Bean
    public WebClient webClient(){
        WebClient webClient = WebClient
                .builder()
                .baseUrl("http://localhost:8080")
                .build();

        return webClient;
    }

    @Bean
    public UrlValidator urlValidator(){
        UrlValidator urlValidator = new UrlValidator();
        return urlValidator;
    }
}
