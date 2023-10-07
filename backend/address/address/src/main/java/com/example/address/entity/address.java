package com.example.address.entity;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "address")
public class address {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String address_id;

    private String building_no;

    private String street;

    private String city;

    private String state;

    private String country;

    private int pincode;

    @Column(nullable = false)
    private String userid;

    private String Typeofaddress;

}
