package com.azanes.surveybuilder.service;

import com.azanes.surveybuilder.exception.UserNotFoundException;
import com.azanes.surveybuilder.model.User;
import com.azanes.surveybuilder.repo.UserRepo;
import com.sun.net.httpserver.HttpsServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class UserService {
    private final UserRepo userRepo;

    @Autowired
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public List<User> findAllUser() {
        return userRepo.findAll();
    }

    public User findUserById(Long id) {
        return userRepo.findUserById(id)
                .orElseThrow(() -> new UserNotFoundException("User: " + id + " is not found."));
    }

    //USE IN LOGIN PAGE
    public User findUserByUsername(String username) {
        return userRepo.findUserByUsername(username)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Username already taken."));
    }

    //USE IN SIGNUP PAGE
    public User addUser(User user) {
        if (userRepo.findUserByUsername(user.getUsername()).isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Username already taken.");
        }
        return userRepo.save(user);
    }
}
