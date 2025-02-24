package com.example.holistitimeapi.adapter;

import com.example.holistitimeapi.model.Community;
import com.example.holistitimeapi.model.CommunityRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
interface SqlCommunityRepository extends CommunityRepository, JpaRepository<Community, Integer> {
}
