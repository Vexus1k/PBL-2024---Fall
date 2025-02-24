package com.example.holistitimeapi.adapter;

import com.example.holistitimeapi.model.Like;
import com.example.holistitimeapi.model.LikeRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SqlLikeRepository extends LikeRepository, JpaRepository<Like, Integer> {
}
