package com.example.self_management.service;

import com.example.self_management.model.Blog;
import com.example.self_management.repository.BlogRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService {

    private final  BlogRepository blogRepository;

    public  BlogService(BlogRepository blogRepository){
        this.blogRepository =  blogRepository;
    }

    public List<Blog> getALlBlogs(){
        return blogRepository.findAll();
    }

}
