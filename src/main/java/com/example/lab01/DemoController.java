package com.example.lab01;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping
public class DemoController {
    @GetMapping("/")
    public List<Book> getBooks(){
        List<Book> books = new ArrayList<>();
        books.add(new Book(1, "demo_book_1", "01"));
        books.add(new Book(2, "demo_book_2", "02"));
        books.add(new Book(3, "demo_book_3", "03"));
        return books;
    }
}
