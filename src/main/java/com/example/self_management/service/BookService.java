package com.example.self_management.service;

import com.example.self_management.model.Book;
import com.example.self_management.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class BookService {
    private final BookRepository bookRepository;

    public  BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBook(){
        return bookRepository.findAll();
    }

    public Book createBook(Book book){
        book.setUploadDate(new Date());
        return bookRepository.save(book);
    }
}
