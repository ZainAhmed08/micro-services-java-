package com.practice.user.service.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//since we are not storing this in user data base we dont need to make it as an entity
public class Rating {
    private String ratindId;
    private String userId;
    private String hotelId;
    private int rating;
    private String feedback;
    private Hotel hotel;
}
