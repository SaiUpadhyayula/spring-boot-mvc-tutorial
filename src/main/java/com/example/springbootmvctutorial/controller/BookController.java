package com.example.springbootmvctutorial.controller;

import com.example.springbootmvctutorial.forms.BookForm;
import com.example.springbootmvctutorial.mapper.BookMapper;
import com.example.springbootmvctutorial.model.Book;
import com.example.springbootmvctutorial.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;
    private final BookMapper bookMapper;

    @GetMapping
    public String home() {
        return "home";
    }

    @GetMapping("/add")
    public String addBookPage(Model model) {
        model.addAttribute("book", new BookForm());
        return "/posts/add";
    }

    @GetMapping("/{shortLink}")
    public String bookDetails(@PathVariable String shortLink, ModelAndView modelAndView) {
        Book bookByShortLink = bookService.getBookByShortLink(shortLink);
        modelAndView.addObject("book", bookByShortLink);
        return "/view";
    }

    @PostMapping
    public String createBook(@RequestBody @Valid BookForm bookForm, BindingResult bindingResult, ModelAndView modelAndView) {
        if (bindingResult.hasErrors()) {
            return "/book/add";
        }
        Book book = bookMapper.mapToBook(bookForm);
        modelAndView.addObject("book", bookService.save(book));
        return "redirect:/home";
    }

    @PutMapping("/{shortLink}")
    public String updateBook(@RequestBody @Valid BookForm bookForm, @PathVariable String shortLink, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/book/add";
        }
        Book book = bookMapper.mapToBook(bookForm);
        bookService.update(shortLink, book);
        return "redirect:/home";
    }

    @DeleteMapping("/{shortLink}")
    public String deleteBook(@PathVariable String shortLink) {
        bookService.delete(shortLink);
        return "redirect:/home";
    }
}
