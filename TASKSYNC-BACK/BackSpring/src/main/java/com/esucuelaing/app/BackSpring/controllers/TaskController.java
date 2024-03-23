package com.esucuelaing.app.BackSpring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import com.esucuelaing.app.BackSpring.dto.TaskDto;
import com.esucuelaing.app.BackSpring.global.dto.MessageDto;
import com.esucuelaing.app.BackSpring.global.exceptions.ResourceNotFoundException;
import com.esucuelaing.app.BackSpring.model.Task;
import com.esucuelaing.app.BackSpring.service.TaskService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/task")
public class TaskController {

    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public ResponseEntity<List<Task>> getAll(){
        return ResponseEntity.ok(taskService.getAll());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Task> getOne(@PathVariable("id") int id) throws ResourceNotFoundException {
        return ResponseEntity.ok(taskService.getOne(id));
    }

    @PostMapping
    public ResponseEntity<MessageDto> save(@Valid @RequestBody TaskDto dto) {
        Task task = taskService.save(dto);
        String message = "task " + task.getName() + " have been saved";
        return ResponseEntity.ok(new MessageDto(HttpStatus.OK, message));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MessageDto> update(@PathVariable("id") int id,@Valid @RequestBody TaskDto dto) throws ResourceNotFoundException {
        Task task = taskService.update(id, dto);
        String message = "task " + task.getName() + " have been updated";
        return ResponseEntity.ok(new MessageDto(HttpStatus.OK, message));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MessageDto> delete(@PathVariable("id") int id) throws ResourceNotFoundException {
        Task task = taskService.delete(id);
        String message = "task " + task.getName() + " have been deleted";
        return ResponseEntity.ok(new MessageDto(HttpStatus.OK, message));
    }
}
