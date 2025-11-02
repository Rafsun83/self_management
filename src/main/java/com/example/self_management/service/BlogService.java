package com.example.self_management.service;

import com.example.self_management.model.domain.Blog;
import com.example.self_management.persistence.repository.BlogRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
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

    public Blog createBlog(Blog blog){
        blog.setPublishedDate(new Date());
//        blog.setUpdateDate(new Date());
        return blogRepository.save(blog);
    }

}
