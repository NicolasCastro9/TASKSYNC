package com.esucuelaing.app.BackSpring.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "tasks")
public class Task {
    @Id
    private int id;
    private String name;
    private String description;
    private String createdBy;
    private String status;
    private LocalDateTime createdAt;

        // Constructor
    public Task() {
    }

    public Task(int id, String name, String description, String createdBy, String status, LocalDateTime createdAt ){
        this.id = id;
        this.name = name;
        this.description = description;
        this.createdBy = createdBy;
        this.status = status;
        this.createdAt = createdAt;

    }

    // Getters
    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public String getStatus() {
        return status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    // Setters
    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}