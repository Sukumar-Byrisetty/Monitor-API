package com.vanavil.monitorresourcesapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vanavil.monitorresourcesapi.model.UserProfile;
import com.vanavil.monitorresourcesapi.repository.UserProfileRepository;


@Service
public class UserProfileService {

    @Autowired
    private UserProfileRepository userProfileRepository;

    public UserProfile createUserProfile(UserProfile userProfile) {
        return userProfileRepository.save(userProfile);
    }

    public List<UserProfile> getAllUserProfiles() {
        return userProfileRepository.findAll();
    }

    public UserProfile getUserProfileById(String id) {
        return userProfileRepository.findById(id).orElse(null);
    }

    public UserProfile updateUserProfile(String id, UserProfile userProfileDetails) {
        UserProfile userProfile = userProfileRepository.findById(id).orElse(null);
        if (userProfile != null) {
            userProfile.setUsername(userProfileDetails.getUsername());
            userProfile.setEmail(userProfileDetails.getEmail());
            userProfile.setFirstname(userProfileDetails.getFirstname());
            userProfile.setLastname(userProfileDetails.getLastname());
            userProfile.setPhonenumber(userProfileDetails.getPhonenumber());
            userProfile.setWebsites(userProfileDetails.getWebsites());
            return userProfileRepository.save(userProfile);
        }
        return null;
    }

    public void deleteUserProfile(String id) {
        userProfileRepository.deleteById(id);
    }
}
