package com.example.self_management.service;

import com.example.self_management.model.domain.Task;
import com.example.self_management.persistence.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getAllTasks(){
        return taskRepository.findAll();
    }

    public Task createTask(Task task){
        task.setCreateTime(new Date());
        return taskRepository.save(task);
    }
}
