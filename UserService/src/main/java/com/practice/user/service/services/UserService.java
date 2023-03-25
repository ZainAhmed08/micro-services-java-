package com.practice.user.service.services;

import com.practice.user.service.entities.User;

import java.util.List;

public interface UserService {

    //user operations

    //create
    User saveUser(User user);

    //get all users
    List<User> getAllUsers();

    //get single user with given user id
    User getUser(String userId);

    //TODO: delete
    //TODO: update

}
