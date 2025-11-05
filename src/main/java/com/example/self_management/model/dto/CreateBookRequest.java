package com.example.self_management.model.dto;


public record CreateBookRequest(String title, String author, String about, String category, String coverImage) {
}
