package com.practice.rating.RatingService.repositories;

import com.practice.rating.RatingService.entities.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RatingRepository extends JpaRepository<Rating,String> {

    //coustome finder methods
    List<Rating> findByUserId(String userId);
    List<Rating> findByHotelId(String hotelId);
}
