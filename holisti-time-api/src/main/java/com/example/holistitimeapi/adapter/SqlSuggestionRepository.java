package com.example.holistitimeapi.adapter;

import com.example.holistitimeapi.model.Suggestion;
import com.example.holistitimeapi.model.SuggestionRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface SqlSuggestionRepository extends SuggestionRepository, JpaRepository<Suggestion, Integer> {
}
