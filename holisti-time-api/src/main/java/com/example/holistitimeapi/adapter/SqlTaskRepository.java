package com.example.holistitimeapi.adapter;

import com.example.holistitimeapi.model.Task;
import com.example.holistitimeapi.model.TaskRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface SqlTaskRepository extends TaskRepository, JpaRepository<Task, Integer> {
}
