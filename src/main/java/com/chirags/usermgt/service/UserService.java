package com.chirags.usermgt.service;

import com.chirags.usermgt.model.UserDetails;

public interface UserService {
    public UserDetails createUser(UserDetails user);
    public boolean checkEmail(String email);
}
