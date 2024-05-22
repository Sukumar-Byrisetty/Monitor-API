// UserService.java
package com.vanavil.monitorresourcesapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vanavil.monitorresourcesapi.model.User;
import com.vanavil.monitorresourcesapi.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User loginUser(String mobileNumber, String password) {
        User user = userRepository.findByMobileNumber(mobileNumber);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return (null);
    }
}
