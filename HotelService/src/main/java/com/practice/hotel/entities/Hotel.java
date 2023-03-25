package com.practice.hotel.entities;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Hotels")
public class Hotel {

    @Id
    @Column(name = "ID")
    private String hotelId;

    @Column(name = "NAME")
    private String name;

    @Column(name = "LOCATION")
    private String location;

    @Column(name = "ABOUT")
    private String about;

}
