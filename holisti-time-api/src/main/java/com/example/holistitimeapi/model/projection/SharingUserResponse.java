package com.example.holistitimeapi.model.projection;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SharingUserResponse {
    private int id;
    private String firstName;
    private String lastName;
}
