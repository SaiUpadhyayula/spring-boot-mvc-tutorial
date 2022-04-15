package com.example.springbootmvctutorial.service;

import com.example.springbootmvctutorial.client.OpenLibraryClient;
import com.example.springbootmvctutorial.model.Book;
import com.example.springbootmvctutorial.repository.BookRepository;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;
    private final OpenLibraryClient openLibraryClient;

    public Book getBookByShortLink(String shortLink) {
        return bookRepository.findByShortLink(shortLink)
                .orElseThrow(() -> new IllegalArgumentException("Cannot find post by shortLink " + shortLink));
    }

    public Book save(Book post) {
        JsonNode forObject = openLibraryClient.getBooksByISBN(post.getIsbn());
        if (forObject != null) {
            return bookRepository.save(post);
        } else {
            throw new IllegalArgumentException("Invalid ISBN " + post.getId());
        }
    }

    public void update(String shortLink, Book book) {
        Book bookByShortLink = getBookByShortLink(shortLink);
        bookByShortLink.setTitle(book.getTitle());
        bookByShortLink.setDescription(book.getDescription());
        bookByShortLink.setIsbn(book.getIsbn());
        bookByShortLink.setCreatedAt(book.getCreatedAt());
        bookRepository.save(bookByShortLink);
    }

    public void delete(String shortLink) {
        bookRepository.delete(getBookByShortLink(shortLink));
    }
}
