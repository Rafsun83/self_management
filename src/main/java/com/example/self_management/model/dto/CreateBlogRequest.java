package com.example.self_management.model.dto;


import java.util.Date;

public record CreateBlogRequest(String title, String content, String authorName, String category, String thumbnail, Date publishedDate, Date updatedDate) {
}
