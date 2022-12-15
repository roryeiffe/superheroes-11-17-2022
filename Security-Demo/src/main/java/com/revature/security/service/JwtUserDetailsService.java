package com.revature.security.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
// The purpose of this class to authenticate users with our database:
public class JwtUserDetailsService implements UserDetailsService {

    // given a username, return a user object:
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // use dummy data for now, but in a real application, you would want to check our respository for the user info:
        if(username.equals("roryeiffe")) {
            // we use bcrypt to hash the password:
            // https://www.javainuse.com/onlineBcrypt
            return new User("roryeiffe", "$2a$10$0GW6ijLSGUrgYSqJJPEnR.ExzK2MZf6ifBfwSZDfKDAlTaqG.V/Gu", new ArrayList<>());
        }
        else {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }
}
