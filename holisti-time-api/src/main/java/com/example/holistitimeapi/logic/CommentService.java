package com.example.holistitimeapi.logic;

import com.example.holistitimeapi.model.Comment;
import com.example.holistitimeapi.model.CommentRepository;
import com.example.holistitimeapi.model.Community;
import com.example.holistitimeapi.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;

    public Comment addComment(User user, Community community, String content) {
        Comment comment = new Comment();
        comment.setContent(content);
        comment.setUser(user);
        comment.setCommunity(community);
        comment.setCommentDate(LocalDateTime.now());

        return commentRepository.save(comment);
    }
}
