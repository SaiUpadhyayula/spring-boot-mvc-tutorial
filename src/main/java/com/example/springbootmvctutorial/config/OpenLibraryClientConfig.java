package com.example.springbootmvctutorial.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class OpenLibraryClientConfig {

    @Value("${openlibrary-root-uri}")
    private String openLibraryRootUri;

    @Bean
    public RestTemplate openLibraryRestTemplate() {
        return new RestTemplateBuilder()
                .rootUri(openLibraryRootUri)
                .build();
    }

    @Bean
    public WebClient openLibraryWebClientBean() {
        return WebClient.builder()
                .baseUrl(openLibraryRootUri)
                .build();
    }
}
