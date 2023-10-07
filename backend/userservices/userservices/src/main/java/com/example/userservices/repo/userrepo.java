package com.example.userservices.repo;

import com.example.userservices.Entity.user;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface userrepo extends JpaRepository<user, String> {
    List<user> findByUsername(String username);
}
