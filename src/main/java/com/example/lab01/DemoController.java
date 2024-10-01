package com.example.lab01;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping
public class DemoController {
    @GetMapping(value = "/books", produces = "application/cs.miu.edu-v1+json")
    public List<Book> getBooks(){
        List<Book> books = new ArrayList<>();
        books.add(new Book(1, "demo_book_1", "01"));
        books.add(new Book(2, "demo_book_2", "02"));
        books.add(new Book(3, "demo_book_3", "03"));
        return books;
    }

    @GetMapping(value = "/books", produces = "application/cs.miu.edu-v2+json")
    public List<Book> getBooks2(){
        List<Book> books = new ArrayList<>();
        books.add(new Book(1, "demo_book_1", "01"));
        books.add(new Book(2, "demo_book_2", "02"));
        books.add(new Book(3, "demo_book_3", "03"));
        return books;
    }

    @GetMapping("/books/{id}")
    public Book getBooks(@PathVariable int id){
        List<Book> books = new ArrayList<>();
        books.add(new Book(1, "demo_book_1", "01"));
        books.add(new Book(2, "demo_book_2", "02"));
        books.add(new Book(3, "demo_book_3", "03"));
        return books.stream().filter(item -> item.getId() == id)
                .findFirst().get();
    }

    @GetMapping(value = "/books/{id}", headers = "X-API-VERSION=2")
    public Book getBooks2(@PathVariable int id){
        List<Book> books = new ArrayList<>();
        books.add(new Book(1, "demo_book_1", "01"));
        books.add(new Book(2, "demo_book_2", "02"));
        books.add(new Book(3, "demo_book_3", "03"));
        return books.stream().filter(item -> item.getId() == id)
                .findFirst().get();
    }

    @PostMapping("/books")
    @ResponseBody
    public Book addBooks(@RequestBody Book book) {
        return book;
    }

    @PostMapping("/v2/books")
    @ResponseBody
    public Book addBooks2(@RequestBody Book book) {
        return book;
    }

    @PutMapping("/books/{id}")
    public int updateBooks(@PathVariable int id, @RequestBody Book book) {
        System.out.println(book);
        return id;
    }

    @DeleteMapping("books/{id}")
    public Book deleteBooks(@PathVariable int id) {
        List<Book> books = new ArrayList<>();
        books.add(new Book(1, "demo_book_1", "01"));
        books.add(new Book(2, "demo_book_2", "02"));
        books.add(new Book(3, "demo_book_3", "03"));

        Book b = books.stream().filter(item -> item.getId() == id).findFirst().get();
        books.remove(b);
        return b;
    }


    @DeleteMapping(value = "books/{id}", params = "version=2")
    public Book deleteBooks2(@PathVariable int id) {
        List<Book> books = new ArrayList<>();
        books.add(new Book(1, "demo_book_1", "01"));
        books.add(new Book(2, "demo_book_2", "02"));
        books.add(new Book(3, "demo_book_3", "03"));

        Book b = books.stream().filter(item -> item.getId() == id).findFirst().get();
        books.remove(b);
        return b;
    }

}
