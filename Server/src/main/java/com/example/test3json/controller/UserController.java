package com.example.test3json.controller;

import com.example.test3json.repository.UserRepository;
import com.example.test3json.model.User;
import java.util.HashMap;
import java.util.Map;

import com.example.test3json.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;


    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody User user) {

        // verificam daca user-ul exista in baza de date
        User foundUSer = userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
        if (foundUSer != null) {
            // creem un obiect de tipul Map care va fi convertit în JSON
            Map<String, String> responseMap = new HashMap<>();
            responseMap.put("token", "dfsgjksdbgksbgsbgvsbgfd");

            // returnam raspunsul sub forma de JSON (200 ok)
            return ResponseEntity.ok(responseMap);
        } else {
            // creem un obiect de tipul Map care va fi convertit în JSON
            Map<String, String> responseMap = new HashMap<>();
            responseMap.put("message", "Username-ul sau password sunt incorecte");

            // 401 (Unauthorized)
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(responseMap);
        }
    }

        @PostMapping("/register")
        public ResponseEntity<Map<String, String>> registerUser(@RequestBody User user) {
        // boolean userExist = userService.checkIfUserExists(user.getUsername());

            if (userService.checkIfUserExists(user.getUsername())) {
                // creem un obiect de tipul Map care va fi convertit în JSON
                Map<String, String> responseMap = new HashMap<>();
                responseMap.put("message", "Utilizatorul exista");


                // returnam raspunsul sub forma de JSON (200 ok)
                return ResponseEntity.ok(responseMap);
            } else {
                // creem un obiect de tipul Map care va fi convertit în JSON
                Map<String, String> responseMap = new HashMap<>();
                responseMap.put("token", "jgfdhefhgfehfsbdf");
                userService.saveUser(user);

                return ResponseEntity.ok(responseMap);

            }

//            if (userService.checkIfUserExists(user.getUsername())) {
//                //return ResponseEntity.badRequest().body("User already exists.");
//                Map<String, String> responseMap = new HashMap<>();
//                responseMap.put("token", "dfsgjksdbgksbgsbgvsbgfd");
//            }
//            userService.saveUser(user);
//            return ResponseEntity.ok("User registered successfully.");
        }
    }