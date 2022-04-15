package com.example.springbootmvctutorial.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    private Long id;
    private String title;
    private String description;
    private String isbn;
    private String shortLink;
    private Author author;
    private List<BookReview> bookReviews;
    private List<BookCategory> bookCategory;
    private Instant createdAt;
}
