package com.example.springbootmvctutorial.client;

import com.fasterxml.jackson.databind.JsonNode;

public interface OpenLibraryClient {
    JsonNode getBooksByISBN(String isbn);
}
