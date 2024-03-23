package com.esucuelaing.app.BackSpring.dto;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;

public class TaskDto {
    @NotBlank(message = "el nombre es obligatorio")
    private String name;
    @NotBlank(message = "la descripción es obligatoria")
    private String description;
    @NotBlank(message = "ponga su nombre")
    private String createdBy;
    @NotBlank(message = "el estado es obligatorio")
    private String status;
    private LocalDateTime createdAt;


    public TaskDto() {
    }

    public TaskDto(String name, String description, String createdBy, String status){
        
        this.name = name;
        this.description = description;
        this.createdBy = createdBy;
        this.status = status;
        this.createdAt = LocalDateTime.now();

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
