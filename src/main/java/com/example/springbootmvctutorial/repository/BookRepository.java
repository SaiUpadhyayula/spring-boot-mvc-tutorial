package com.example.springbootmvctutorial.repository;

import com.example.springbootmvctutorial.model.Book;

import java.util.Optional;

public interface BookRepository {
    Book save(Book post);

    Optional<Book> findByShortLink(String shortLink);

    void delete(Book bookByShortLink);
}
