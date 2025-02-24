package com.example.holistitimeapi.adapter;

import com.example.holistitimeapi.model.Comment;
import com.example.holistitimeapi.model.CommentRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SqlCommentRepository extends CommentRepository, JpaRepository<Comment, Integer> {
}
