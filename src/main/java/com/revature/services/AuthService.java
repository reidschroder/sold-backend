package com.revature.services;

import com.revature.exceptions.InvalidUserException;
import com.revature.models.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {
    private final UserService userService;

    public AuthService(UserService userService) {
        this.userService = userService;
    }
    public Optional<User> findByCredentials(String username, String password) throws InvalidUserException {
            return userService.findByCredentials(username, password);
    }
    public User register(User user) {
        return userService.save(user);
    }
}
