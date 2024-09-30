package com.example.lab01;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@AllArgsConstructor
public class Book {
    private int id;
    private String title;
    private String isbn;
}
