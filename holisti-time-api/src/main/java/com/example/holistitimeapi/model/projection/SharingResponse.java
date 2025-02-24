package com.example.holistitimeapi.model.projection;

import com.example.holistitimeapi.model.Community;
import com.example.holistitimeapi.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SharingResponse {
    private int id;
    private SharingUserResponse user;
    private SharingCommunityResponse sharedPost;
    private LocalDateTime sharingDate;
}
