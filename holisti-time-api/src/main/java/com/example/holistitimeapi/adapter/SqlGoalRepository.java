package com.example.holistitimeapi.adapter;

import com.example.holistitimeapi.model.Goal;
import com.example.holistitimeapi.model.GoalRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface SqlGoalRepository extends GoalRepository, JpaRepository<Goal, Integer> {
}
