package com.example.holistitimeapi.adapter;

import com.example.holistitimeapi.model.Progress;
import com.example.holistitimeapi.model.ProgressRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface SqlProgressRepository extends ProgressRepository, JpaRepository<Progress, Integer> {

}
