package com.example.self_management.mapper;

import com.example.self_management.model.domain.Blog;
import com.example.self_management.model.dto.CreateBlogRequest;
import com.example.self_management.persistence.entity.BlogEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class BlogMapper {

    public Blog entityToDomain(BlogEntity blogEntity){
        Blog domain = new Blog();
        BeanUtils.copyProperties(blogEntity,domain);
        return domain;
    }

    public BlogEntity createBlogRequestToEntity(CreateBlogRequest createBlogRequest) {
        BlogEntity blogEntity = new BlogEntity();
        BeanUtils.copyProperties(createBlogRequest, blogEntity);
        return blogEntity;
    };
}
