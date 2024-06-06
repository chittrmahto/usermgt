package com.chirags.usermgt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chirags.usermgt.model.UserDetails;

public interface UserRepository extends JpaRepository<UserDetails, Integer> {
    public boolean existsByEmail(String email);
}
