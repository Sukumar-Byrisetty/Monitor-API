// AuthController.java
package com.vanavil.monitorresourcesapi.controller;

import com.vanavil.monitorresourcesapi.model.User;
import com.vanavil.monitorresourcesapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        String mobileNumber = loginRequest.getMobileNumber();
        String password = loginRequest.getPassword();

        User user = userService.loginUser(mobileNumber, password);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid mobile number or password");
        }
    }
}