package com.example.holistitimeapi.adapter;

import com.example.holistitimeapi.model.Note;
import com.example.holistitimeapi.model.NoteRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SqlNoteRepository extends NoteRepository, JpaRepository<Note, Integer> {
}
