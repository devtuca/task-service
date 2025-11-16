package com.desafio_spring.desafio.handler;

public class TaskNotFoundException extends RuntimeException {


    public TaskNotFoundException(long id) {
        super("Task with id: " + id + " not found");
    }

}
