package com.practice.rating.RatingService.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Rating {

    @Id
    private String ratindId;
    private String userId;
    private String hotelId;
    private int rating;
    private String feedback;
    @Transient
    private Hotel hotel;
}
