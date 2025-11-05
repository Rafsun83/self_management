package com.example.self_management.controller;


import com.example.self_management.model.domain.Book;
import com.example.self_management.model.dto.CreateBookRequest;
import com.example.self_management.service.BookService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public List<Book> getAllBooks(@ParameterObject Pageable pageable) {
        return bookService.getAllBook(pageable);
    }

    @Operation(summary = "Create Book", description = "Create all books")
    @PostMapping
    public Long createBook(@RequestBody CreateBookRequest createBookRequest) {
        return bookService.createBook(createBookRequest);
    }
}
