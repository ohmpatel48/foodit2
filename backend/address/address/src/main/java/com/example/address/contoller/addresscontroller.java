package com.example.address.contoller;

import com.example.address.entity.address;
import com.example.address.service.serviceimpel.addressserviceimpel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/address")
public class addresscontroller {

    @Autowired
    addressserviceimpel addresserviceimpel;

    @PutMapping
    public ResponseEntity<address> addaddress(@PathVariable address address){
        address address1 = addresserviceimpel.putaddress(address);
        return ResponseEntity.status(HttpStatus.CREATED).body(address1);
    }
    @GetMapping("/{userid}")
    public ResponseEntity<Optional<address>> getaddressbyuserid(@PathVariable String userid){
        return ResponseEntity.ok(addresserviceimpel.getbyuserid(userid));
    }
}
