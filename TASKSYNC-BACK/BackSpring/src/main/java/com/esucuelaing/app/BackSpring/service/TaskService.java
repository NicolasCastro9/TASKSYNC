package com.esucuelaing.app.BackSpring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.esucuelaing.app.BackSpring.repository.*;
import com.esucuelaing.app.BackSpring.dto.TaskDto;
import com.esucuelaing.app.BackSpring.global.exceptions.ResourceNotFoundException;
import com.esucuelaing.app.BackSpring.model.*;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;

@Service
public class TaskService {
    @Autowired
    private  TaskRepository taskRepository;

    public List<Task> getAll() {
        return taskRepository.findAll();
    }

    public Task getOne(int id) throws ResourceNotFoundException{
        return taskRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("not found"));
    }

    public  Task save(TaskDto dto){
        int id = autoIncrement();
        LocalDateTime createdAt = LocalDateTime.now();
        Task task = new Task(id, dto.getName(),dto.getDescription(),dto.getCreatedBy(),dto.getStatus(),createdAt);
        return taskRepository.save(task);
    }

    public  Task update(int id,TaskDto dto) throws ResourceNotFoundException{
        Task task = taskRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("not found"));
        task.setName(dto.getName());
        task.setDescription(dto.getDescription());
        task.setCreatedBy(dto.getCreatedBy());
        task.setStatus(dto.getStatus());
        task.setCreatedAt(LocalDateTime.now());
        return taskRepository.save(task);
    }

    public  Task delete(int id) throws ResourceNotFoundException{
        Task task = taskRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("not found"));
        taskRepository.delete(task);
        return task;
    }


    private  int autoIncrement() {
        List<Task> tasks = taskRepository.findAll();
        return tasks.isEmpty()? 1 : tasks.stream().max(Comparator.comparing(Task::getId)).get().getId() + 1;
    }

}
