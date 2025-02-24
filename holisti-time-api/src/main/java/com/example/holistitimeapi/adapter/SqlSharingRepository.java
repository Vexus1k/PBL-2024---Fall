package com.example.holistitimeapi.adapter;

import com.example.holistitimeapi.model.Sharing;
import com.example.holistitimeapi.model.SharingRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SqlSharingRepository  extends SharingRepository, JpaRepository<Sharing, Integer> {
}
