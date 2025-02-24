package com.example.holistitimeapi.model;

import java.util.List;

public interface SharingRepository {
    Sharing save(Sharing sharing);

    List<Sharing> findAll();
}
