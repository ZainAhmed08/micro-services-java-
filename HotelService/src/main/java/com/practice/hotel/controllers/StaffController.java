package com.practice.hotel.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/staff")
public class StaffController {
    @GetMapping
    public ResponseEntity<List<String>> getStaff(){
       List<String> staff =  Arrays.asList("zain","farhaan","shahistha","sadiya","khatija","ayesha","ajju","hajara","rehaan");
       return new ResponseEntity<>(staff, HttpStatus.OK);
    }
}
