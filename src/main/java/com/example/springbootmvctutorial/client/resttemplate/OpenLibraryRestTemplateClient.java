package com.example.springbootmvctutorial.client.resttemplate;

import com.example.springbootmvctutorial.client.OpenLibraryClient;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
@Primary
public class OpenLibraryRestTemplateClient implements OpenLibraryClient {

    private final RestTemplate openLibraryRestTemplate;

    @Override
    public JsonNode getBooksByISBN(String isbn) {
        return openLibraryRestTemplate.getForObject(String.format("/api/books?&bibkeys=ISBN:%s&format=json&jscmd=data", isbn), JsonNode.class);
    }
}
