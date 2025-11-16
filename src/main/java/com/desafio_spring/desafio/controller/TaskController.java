package com.desafio_spring.desafio.controller;

import com.desafio_spring.desafio.model.Task;
import com.desafio_spring.desafio.service.TaskService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController {

    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @Operation(summary = "Cria uma nova task", description = "Recebe título e descrição e cria uma task")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Task criada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos")
    })
    @PostMapping("/task")
    public ResponseEntity<Task> create(@Valid @RequestBody Task task) {
        Task taskCreated = taskService.create(task);
        return ResponseEntity.status(HttpStatus.CREATED).body(taskCreated);
    }

    @Operation(summary = "Lista todas as tasks", description = "Retorna uma lista de todas as tasks cadastradas")
    @GetMapping("/tasks")
    public ResponseEntity<List<Task>> getAllTasks() {
        return ResponseEntity.ok(taskService.getAll());
    }

    @Operation(summary = "Busca task por ID")
    @GetMapping("/task/{id}")
    public ResponseEntity<Task> getByID(@PathVariable long id) {
        return ResponseEntity.ok(taskService.getById(id));
    }

    @Operation(summary = "Atualiza título e descrição de uma task")
    @PutMapping("/task/{id}")
    public ResponseEntity<Task> update(@PathVariable long id, @Valid @RequestBody Task task) {
        Task taskUpdated = taskService.update(id, task);
        return ResponseEntity.ok(taskUpdated);
    }

    @Operation(summary = "Deleta uma task")
    @DeleteMapping("/task/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable long id) {
        taskService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Marca task como completa")
    @PatchMapping("/task/{id}/complete")
    public ResponseEntity<Task> patch(@PathVariable long id) {
        Task taskUpdated = taskService.complete(id);
        return ResponseEntity.ok(taskUpdated);
    }
}
