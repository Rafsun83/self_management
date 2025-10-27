package com.example.self_management.controller;

import com.example.self_management.model.Task;
import com.example.self_management.service.TaskService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
@Tag(name="All Tasks", description = "Get all task")
public class TaskController {
    private final TaskService taskService;
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @Operation(summary = "All Task", description = "Get all task for this system")
    @GetMapping
    public List<Task> getAllTasks(){
        return taskService.getAllTasks();
    }

    @Operation(summary = "Create Task", description = "Create Task API")
    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Task task){
        Task saveTask = taskService.createTask(task);
        return ResponseEntity.ok(saveTask);
    }

}
