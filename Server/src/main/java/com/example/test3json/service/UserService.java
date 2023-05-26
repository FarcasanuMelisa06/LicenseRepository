package com.example.test3json.service;

import com.example.test3json.model.User;
import com.example.test3json.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public boolean checkIfUserExists(String username) {
        return userRepository.findByUsername(username) != null;
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }

    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

}

