package com.example.springbootmvctutorial.client.webclient;

import com.example.springbootmvctutorial.client.OpenLibraryClient;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
@RequiredArgsConstructor
public class OpenLibraryWebClient implements OpenLibraryClient {

    private final WebClient openLibraryWebClientBean;

    @Override
    public JsonNode getBooksByISBN(String isbn) {
        return openLibraryWebClientBean.get()
                .uri(String.format("https://openlibrary.org/api/books?&bibkeys=ISBN:%s&format=json&jscmd=data", isbn))
                .retrieve()
                .bodyToMono(JsonNode.class)
                .block();
    }
}
