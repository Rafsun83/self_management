package com.example.self_management.controller;

import com.example.self_management.model.Blog;
import com.example.self_management.repository.BlogRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/blogs")
public class BlogController {

    private final BlogRepository blogRepository;
    public BlogController(BlogRepository blogRepository){
        this.blogRepository = blogRepository;
    }

    @GetMapping
    public List<Blog> getAllBlogs(){
        return blogRepository.findAll();
    }
}
