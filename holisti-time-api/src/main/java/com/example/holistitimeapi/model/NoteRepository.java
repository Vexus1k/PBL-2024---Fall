package com.example.holistitimeapi.model;

import com.example.holistitimeapi.user.User;

import java.util.List;

public interface NoteRepository {
    Note save(Note note);

    void deleteById(int noteId);

    List<Note> findByUser(User user);
}
