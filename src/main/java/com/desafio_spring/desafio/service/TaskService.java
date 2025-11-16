package com.desafio_spring.desafio.service;

import com.desafio_spring.desafio.handler.TaskException;
import com.desafio_spring.desafio.handler.TaskNotFoundException;
import com.desafio_spring.desafio.model.Task;
import com.desafio_spring.desafio.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;


    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task complete(long id) {
        Task taskUpdating = getById(id);

        if (taskUpdating.isCompleted())
            throw new TaskException("Task can't be completed because he is already completed");

        taskUpdating.setCompleted(true);
        taskUpdating.setDateCompleted(Instant.now());
        taskRepository.save(taskUpdating);
        return taskUpdating;
    }

    public Task create(Task task) {

        task.setDateCreation(Instant.now());
        task.setDateCompleted(null);
        task.setCompleted(false);
        return taskRepository.save(task);

    }

    public List<Task> getAll() {
        return taskRepository.findAll();
    }

    public Task getById(long id) {
        return taskRepository.findById(id).orElseThrow(() -> new TaskNotFoundException(id));
    }

    public void delete(long id) {
        Task taskUpdating = getById(id);
        taskRepository.delete(taskUpdating);
    }

    public Task update(long id, Task task) {

        Task taskUpdating = getById(id);
        taskUpdating.setTitle(task.getTitle());
        taskUpdating.setDescription(task.getDescription());
        taskRepository.save(taskUpdating);

        return taskUpdating;
    }
}
