package com.example.holistitimeapi.logic;

import com.example.holistitimeapi.model.Community;
import com.example.holistitimeapi.model.CommunityRepository;
import com.example.holistitimeapi.model.Like;
import com.example.holistitimeapi.model.LikeRepository;
import com.example.holistitimeapi.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LikeService {

    private final LikeRepository likeRepository;
    private final CommunityRepository communityRepository;

    public boolean userLikedPost(User user, Community post) {
        return likeRepository.existsByUserAndPost(user, post);
    }

    public void toggleLike(User user, Community post) {
        if (userLikedPost(user, post)) {
            unlikePost(user, post);
        } else {
            likePost(user, post);
        }
    }

    public void likePost(User user, Community post) {
        if (!userLikedPost(user, post)) {
            Like like = new Like();
            like.setUser(user);
            like.setPost(post);
            likeRepository.save(like);
        }
    }

    public void unlikePost(User user, Community post) {
        if (userLikedPost(user, post)) {
            Like like = likeRepository.findByUserAndPost(user, post);
            likeRepository.delete(like);
        }
    }

    public int getLikesCountForPost(Community post) {
        return post.getLikesCount();
    }
}

