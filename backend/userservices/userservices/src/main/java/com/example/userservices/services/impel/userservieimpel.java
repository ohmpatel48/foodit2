package com.example.userservices.services.impel;

import com.example.userservices.Entity.alldetails;
import com.example.userservices.Entity.user;
import com.example.userservices.repo.userrepo;
import com.example.userservices.services.userservices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class userservieimpel implements userservices {

    @Autowired
    private userrepo userrepo1 ;
    @Override
    public List<user> getAlluser() {
        return userrepo1.findAll();
    }

    @Override
    public List<user> getByusername(String Username) {
        return userrepo1.findByUsername(Username);
    }

    @Override
    public Optional<user> getByuserid(String User_id) {
        return userrepo1.findById(User_id);
    }

    @Override
    public void deleatuser(String User_id) {
        userrepo1.deleteById(User_id);
    }

    @Override
    public user putuser(alldetails userdetails) {
        user temp = new user();
        temp.setUsername(userdetails.getUser_name());
        temp.setEmail(userdetails.getEmail());
        temp.setFirstname(userdetails.getFirst_name());
        temp.setLastname(userdetails.getLast_name());
        temp.setUser_role(userdetails.getUser_role());
        temp.setPassword(userdetails.getPassword());
        return userrepo1.save(temp);
    }
}
