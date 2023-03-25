package com.practice.rating.RatingService.services;

import com.practice.rating.RatingService.entities.Rating;

import java.util.List;

public interface RatingService {

    //create
    Rating createRating(Rating rating);

    //get all ratings
    List<Rating> getRatings();

    //get all ratings by user id
    List<Rating> getRatingsByUserId(String userId);

    //get all by hotel
    List<Rating> getRatingByHotelId(String hotelId);

}
