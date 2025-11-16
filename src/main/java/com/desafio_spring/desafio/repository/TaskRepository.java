package com.desafio_spring.desafio.repository;

import com.desafio_spring.desafio.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TaskRepository extends JpaRepository<Task, Long> {

    Optional<Task> findById(long id);
}
