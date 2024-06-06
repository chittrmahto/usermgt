package com.chirags.usermgt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chirags.usermgt.model.UserDetails;
import com.chirags.usermgt.repository.UserRepository;

@Service
public class UserServiceImplement implements UserService {
    
    @Autowired
    private UserRepository userRepo;

    @Override
    public UserDetails createUser(UserDetails user)
    {
        return userRepo.save(user);
    }

    @Override
    public boolean checkEmail(String email)
    {
        return userRepo.existsByEmail(email);
    }
}
