package com.example.holistitimeapi.model;

import com.example.holistitimeapi.user.User;

import java.util.List;
import java.util.Optional;

public interface TaskRepository {
    Optional<Task> findById(int userId);

    Task save(Task task);

    void deleteById(int taskId);

    List<Task> findByUserId(int userId);
}
