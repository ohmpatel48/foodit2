package com.example.address.repo;

import com.example.address.entity.address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface addressrepo extends JpaRepository<address,String> {

    public Optional<address> getByUserid(String userid);
}
