package com.example.springbootmvctutorial.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookReview {
    private Long id;
    private Book book;
    private String title;
    private String body;
    private Integer rating;
    private Instant publishedAt;
}
