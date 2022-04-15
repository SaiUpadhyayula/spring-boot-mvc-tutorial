package com.example.springbootmvctutorial.repository;

import com.example.springbootmvctutorial.model.Book;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;

@Repository
public class InMemoryBookRepositoryImpl implements BookRepository {

    private final List<Book> bookList = new CopyOnWriteArrayList<>();

    @Override
    public Book save(Book post) {
        bookList.add(post);
        return post;
    }

    @Override
    public Optional<Book> findByShortLink(String shortLink) {
        return bookList.stream()
                .filter(el -> el.getShortLink().equals(shortLink))
                .findAny();
    }

    @Override
    public void delete(Book bookByShortLink) {
        bookList.removeIf(book -> book.getId().equals(bookByShortLink.getId()));
    }
}
