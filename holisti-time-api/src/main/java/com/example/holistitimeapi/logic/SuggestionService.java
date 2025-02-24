package com.example.holistitimeapi.logic;

import com.example.holistitimeapi.model.Suggestion;
import com.example.holistitimeapi.model.SuggestionCategory;
import com.example.holistitimeapi.model.SuggestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SuggestionService {

    private final SuggestionRepository suggestionRepository;

    public Suggestion addSuggestion(Suggestion suggestion) {
        return suggestionRepository.save(suggestion);
    }

    public List<Suggestion> getAllSuggestions() {
        return suggestionRepository.findAll();
    }

    public List<Suggestion> getSuggestionsByCategory(SuggestionCategory category) {
        return suggestionRepository.findBySuggestionCategory(category);
    }
}
