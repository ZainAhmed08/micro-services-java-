package com.practice.user.service.impl;

import com.practice.user.service.entities.Hotel;
import com.practice.user.service.entities.Rating;
import com.practice.user.service.entities.User;
import com.practice.user.service.exceptions.ResourceNotFoundException;
import com.practice.user.service.external.services.HotelService;
import com.practice.user.service.repositories.UserRepository;
import com.practice.user.service.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HotelService hotelService;

    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public User saveUser(User user) {
        //generate unique user id
        String randomUserId = UUID.randomUUID().toString();
        user.setUserId(randomUserId);
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    //get single user
    @Override
    public User getUser(String userId) {
        // get user from database.with the help of user repository
        User user =  userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException());
        // fetch rating from above user from RATING-SERVICE
        //http://localhost:8083/ratings/users/b438e8fc-1198-40b5-9952-e356e44bdb16
        Rating[] ratingOfUser = restTemplate.getForObject("http://RATING-SERVICE/ratings/users/"+user.getUserId(), Rating[].class);
        logger.info("{}", ratingOfUser);

        List<Rating> ratings = Arrays.stream(ratingOfUser).collect(Collectors.toList());

        List<Rating> ratingList = ratings.stream().map(rating -> {
            //api call to hotel service to get hotel
            //http://localhost:8082/hotels/5008270e-d562-41e5-9557-3275e5b14e2c
            //       the rest template implimentation
//            ResponseEntity<Hotel> forEntity = restTemplate.getForEntity("http://HOTEL-SERVICE/hotels/"+rating.getHotelId(),Hotel.class);
            //       the feign client implimentation
//            Hotel hotel = forEntity.getBody();
              Hotel hotel = hotelService.getHotel(rating.getHotelId());
            //set the hotel to rating
            rating.setHotel(hotel);
            //return the rating
            return rating;
        }).collect(Collectors.toList());

        user.setRatings(ratingList);
        return user;
    }

}
