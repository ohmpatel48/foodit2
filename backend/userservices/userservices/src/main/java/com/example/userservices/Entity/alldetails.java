package com.example.userservices.Entity;

import jakarta.persistence.Column;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class alldetails {

    private String User_name;
    private String first_name;
    private String last_name;
    private String Email;
    private String Password;
    private role User_role;
    private long phone;
    private String buildingnumber;
    private String street;
    private String city;
    private String state;
    private String country;
    private int pincode;
    private double longitude;
    private double latitude;
}
