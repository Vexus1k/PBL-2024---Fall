package com.example.holistitimeapi.model;

import com.example.holistitimeapi.user.User;

public interface LikeRepository {
    boolean existsByUserAndPost(User user, Community post);

    Like save(Like like);

    Like findByUserAndPost(User user, Community post);

    void delete(Like like);
}
