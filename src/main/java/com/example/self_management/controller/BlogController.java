package com.example.self_management.controller;

import com.example.self_management.model.Blog;
import com.example.self_management.repository.BlogRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/blogs")
@Tag(name = "Blogs", description = "Get API for all blogs")
public class BlogController {

    private final BlogRepository blogRepository;
    public BlogController(BlogRepository blogRepository){
        this.blogRepository = blogRepository;
    }
    @Operation(summary = "Get all blogs", description = "Get all blogs from the system")
    @GetMapping
    public List<Blog> getAllBlogs(){
        return blogRepository.findAll();
    }
}
