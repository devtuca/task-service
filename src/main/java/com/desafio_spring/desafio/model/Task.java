package com.desafio_spring.desafio.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.Instant;

@Entity
@Data
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Title can't be null")
    private String title;
    @NotBlank(message = "Description can't be null")
    @Size(max = 255, message = "Desc max size is 255")
    private String description;
    private boolean completed;
    private Instant dateCreation;
    private Instant dateCompleted;

}
