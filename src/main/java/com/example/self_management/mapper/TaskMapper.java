package com.example.self_management.mapper;


import com.example.self_management.model.domain.Task;
import com.example.self_management.model.dto.CreateTaskRequest;
import com.example.self_management.persistence.entity.TaskEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class TaskMapper {

    public Task entityToTaskDomain(TaskEntity taskEntity) {
        Task task = new Task();
        BeanUtils.copyProperties(taskEntity,task);
        return task;
    }

    public TaskEntity createTaskRequestToEntity(CreateTaskRequest  createTaskRequest) {
        TaskEntity taskEntity = new TaskEntity();
        taskEntity.setCreateTime(new Date());
        BeanUtils.copyProperties(createTaskRequest,taskEntity);
        return taskEntity;
    }

}
