package com.example.holistitimeapi.logic;

import com.example.holistitimeapi.model.Comment;
import com.example.holistitimeapi.model.Community;
import com.example.holistitimeapi.model.Sharing;
import com.example.holistitimeapi.model.SharingRepository;
import com.example.holistitimeapi.model.projection.CommentResponse;
import com.example.holistitimeapi.model.projection.SharingCommunityResponse;
import com.example.holistitimeapi.model.projection.SharingResponse;
import com.example.holistitimeapi.model.projection.SharingUserResponse;
import com.example.holistitimeapi.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SharingService {

    private final SharingRepository sharingRepository;
    private final CommunityService communityService;

    public List<SharingResponse> getAllSharedPosts() {
        List<Sharing> sharedPosts = sharingRepository.findAll();
        return sharedPosts.stream()
                .map(this::mapToSharingResponse)
                .collect(Collectors.toList());
    }

    public SharingResponse sharePost(Community originalPost, User user) {
        Sharing sharing = new Sharing();
        sharing.setUser(user);
        sharing.setSharedPost(originalPost);
        sharing.setSharingDate(LocalDateTime.now());

        return mapToSharingResponse(sharingRepository.save(sharing));
    }

    private SharingResponse mapToSharingResponse(Sharing sharing) {
        return SharingResponse.builder()
                .id(sharing.getId())
                .user(mapToSharingUserResponse(sharing.getUser()))
                .sharedPost(mapToSharingCommunityResponse(sharing.getSharedPost()))
                .sharingDate(sharing.getSharingDate())
                .build();
    }

    private SharingCommunityResponse mapToSharingCommunityResponse(Community community) {
        List<Comment> comments = community.getComments();
        List<CommentResponse> commentResponses = comments.stream()
                .map(communityService::mapToCommentResponse)
                .toList();

        return SharingCommunityResponse.builder()
                .id(community.getId())
                .user(mapToSharingUserResponse(community.getUser()))
                .content(community.getContent())
                .userLiked(community.isUserLiked())
                .comments(commentResponses)
                .likesCount(community.getLikesCount())
                .publicationDate(community.getPublicationDate())
                .build();
    }

    private SharingUserResponse mapToSharingUserResponse(User user) {
        return SharingUserResponse.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .build();
    }
}

