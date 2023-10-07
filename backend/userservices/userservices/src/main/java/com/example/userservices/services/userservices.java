package com.example.userservices.services;

import com.example.userservices.Entity.alldetails;
import com.example.userservices.Entity.user;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


public interface userservices {
    List<user> getAlluser();
    List<user> getByusername(String Username);
    Optional<user> getByuserid(String User_id);
    void deleatuser(String User_id);
    user putuser(alldetails userdetails);
}
