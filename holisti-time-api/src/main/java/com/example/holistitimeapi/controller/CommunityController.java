package com.example.holistitimeapi.controller;

import com.example.holistitimeapi.logic.CommentService;
import com.example.holistitimeapi.logic.CommunityService;
import com.example.holistitimeapi.logic.LikeService;
import com.example.holistitimeapi.logic.SharingService;
import com.example.holistitimeapi.model.Comment;
import com.example.holistitimeapi.model.Community;
import com.example.holistitimeapi.model.projection.CommentRequest;
import com.example.holistitimeapi.model.projection.CommentResponse;
import com.example.holistitimeapi.model.projection.CommunityRequest;
import com.example.holistitimeapi.model.projection.CommunityResponse;
import com.example.holistitimeapi.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/community")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class CommunityController {

    private final CommunityService communityService;
    private final CommentService commentService;
    private final LikeService likeService;

    @GetMapping("/posts")
    public ResponseEntity<List<CommunityResponse>> getAllCommunityPosts(
            Authentication authentication
    ) {
        User user = (User) authentication.getPrincipal();
        List<CommunityResponse> communityResponses = communityService.getAllCommunityPostsWithComments(user);

        return ResponseEntity.ok(communityResponses);
    }

    @PostMapping("/create-post")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<CommunityResponse> createPost(
        @RequestBody CommunityRequest communityRequest,
        Authentication authentication
    ) {
        User user = (User) authentication.getPrincipal();

        CommunityResponse newPost = communityService.mapToCommunityResponse(communityService.createCommunityPost(user, communityRequest.getContent()), user);

        return ResponseEntity.ok(newPost);
    }

    @PostMapping("/comments")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<CommentResponse> addComment(
            @RequestBody CommentRequest commentRequest,
            Authentication authentication
    ) {
        User user = (User) authentication.getPrincipal();

        Community community = communityService.getCommunityPostById(commentRequest.getPostId());

        if (community == null) {
            return ResponseEntity.notFound().build();
        }

        Comment savedComment = commentService.addComment(
                user,
                community,
                commentRequest.getContent()
        );

        return ResponseEntity.ok(communityService.mapToCommentResponse(savedComment));
    }

    @PostMapping("/posts/{postId}/like")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<Integer> likePost(
            @PathVariable int postId,
            Authentication authentication
    ) {
        User user = (User) authentication.getPrincipal();
        Community post = communityService.getCommunityPostById(postId);

        if (post == null) {
            return ResponseEntity.notFound().build();
        }

        likeService.toggleLike(user, post);
        int likesCount = likeService.getLikesCountForPost(post);

        return ResponseEntity.ok(likesCount);
    }
}
