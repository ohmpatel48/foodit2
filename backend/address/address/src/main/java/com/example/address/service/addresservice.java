package com.example.address.service;

import com.example.address.entity.address;

import java.util.Optional;

public interface addresservice {

    public address putaddress(address address);

    public Optional<address> getbyuserid(String userid);

}
