package com.practice.hotel.services;

import com.practice.hotel.entities.Hotel;

import java.util.List;

public interface HotelService  {

    //create
    Hotel createHotel(Hotel hotel);

    //getAllHotels
    List<Hotel> getAllHotels();

    //get specific hotel
    Hotel getHotel(String hotelId);
}
