package com.example.userservices.contoller;

import com.example.userservices.Entity.alldetails;
import com.example.userservices.Entity.user;
import com.example.userservices.services.impel.userservieimpel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class usercontoller {

    @Autowired
    userservieimpel userserviceimpel;

    @PutMapping
    public ResponseEntity<user> settinguser(@RequestBody alldetails user_details){
        user user1 = userserviceimpel.putuser(user_details);
        return ResponseEntity.status(HttpStatus.CREATED).body(user1);
    }

    @GetMapping("/byId/{userId}")
    public ResponseEntity<Optional<user>> getuserByid(@PathVariable String userId){
        return ResponseEntity.ok(userserviceimpel.getByuserid(userId));
    }

    @GetMapping("/byUsername/{username}")
    public ResponseEntity<List<user>> getuserByUsername(@PathVariable String username){
        return ResponseEntity.ok(userserviceimpel.getByusername(username));
    }

    @DeleteMapping("/{userId}")
    public void delete_user(@PathVariable String userId){
        userserviceimpel.deleatuser(userId);
    }

    @GetMapping("/")
    public ResponseEntity<List<user>> getAlluser(){
        return ResponseEntity.ok(userserviceimpel.getAlluser());
    }

    @GetMapping("/availability/{username}")
    public boolean checkUsername(@PathVariable String username){
        return userserviceimpel.getByusername(username).isEmpty();
    }
}
