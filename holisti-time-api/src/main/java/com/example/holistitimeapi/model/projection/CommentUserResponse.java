package com.example.holistitimeapi.model.projection;

import jakarta.persistence.Column;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommentUserResponse {
    private int id;
    private String firstName;
    private String lastName;
}
