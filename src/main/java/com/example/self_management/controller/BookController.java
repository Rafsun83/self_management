package com.example.self_management.controller;


import com.example.self_management.model.Book;
import com.example.self_management.service.BookService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/books")
@Tag(name="All Books", description = "Get all books")
public class BookController {
    private final BookService bookService;

    public  BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @Operation(summary = "All books", description = "All books for this system")
    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBook();

    }
}
