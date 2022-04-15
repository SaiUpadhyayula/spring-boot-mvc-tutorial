package com.example.springbootmvctutorial.mapper;

import com.example.springbootmvctutorial.forms.BookForm;
import com.example.springbootmvctutorial.model.Author;
import com.example.springbootmvctutorial.model.Book;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class BookMapper {

    public BookForm mapToBookForm(Book book) {
        return new BookForm(book.getId(), book.getTitle(), book.getDescription(),
                book.getIsbn(),
                book.getCreatedAt(), book.getShortLink(), book.getAuthor().getAuthorName());
    }

    public Book mapToBook(BookForm bookForm) {
        return new Book(bookForm.getId(), bookForm.getTitle(), bookForm.getDescription(),
                bookForm.getIsbn(),
                bookForm.getShortLink(),
                new Author(bookForm.getAuthorName()),
                Collections.emptyList(),
                Collections.emptyList(),
                bookForm.getCreatedAt());
    }
}
