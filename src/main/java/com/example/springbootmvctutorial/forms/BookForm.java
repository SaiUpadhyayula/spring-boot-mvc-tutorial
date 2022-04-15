package com.example.springbootmvctutorial.forms;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookForm {
    private Long id;
    private String title;
    private String description;
    private String isbn;
    private Instant createdAt;
    private String shortLink;
    private String authorName;
}
