package com.example.holistitimeapi.controller;

import com.example.holistitimeapi.logic.CommunityService;
import com.example.holistitimeapi.logic.SharingService;
import com.example.holistitimeapi.model.Community;
import com.example.holistitimeapi.model.projection.SharingResponse;
import com.example.holistitimeapi.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sharing")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class SharingController {

    private final SharingService sharingService;
    private final CommunityService communityService;

    @GetMapping("/shared-posts")
    public ResponseEntity<List<SharingResponse>> getAllSharedPosts(
            Authentication authentication
    ) {
        List<SharingResponse> sharedPosts = sharingService.getAllSharedPosts();

        return ResponseEntity.ok(sharedPosts);
    }

    @PostMapping("/posts/{postId}/share")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<SharingResponse> sharePost(
            @PathVariable int postId,
            Authentication authentication
    ) {
        User user = (User) authentication.getPrincipal();
        Community originalPost = communityService.getCommunityPostById(postId);

        if (originalPost == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(sharingService.sharePost(originalPost, user));
    }
}

