package com.example.self_management.model.dto;


public record CreateTaskRequest(String title, String description, String TaskType, Number status, String coverImage) {
}
