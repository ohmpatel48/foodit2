package com.example.address.service.serviceimpel;

import com.example.address.entity.address;
import com.example.address.repo.addressrepo;
import com.example.address.service.addresservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class addressserviceimpel implements addresservice {

    @Autowired
    public addressrepo addressrepo;
    @Override
    public address putaddress(address address) {
        return addressrepo.save(address);
    }

    @Override
    public Optional<address> getbyuserid(String userid) {
        return addressrepo.getByUserid(userid);
    }
}
