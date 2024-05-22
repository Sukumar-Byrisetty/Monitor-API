package com.vanavil.monitorresourcesapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vanavil.monitorresourcesapi.model.UserProfile;
import com.vanavil.monitorresourcesapi.service.UserProfileService;

import java.util.List;

@RestController
@RequestMapping("/api/userprofiles")
public class UserProfileController {

    @Autowired
    private UserProfileService userProfileService;

    @PostMapping
    public ResponseEntity<UserProfile> createUserProfile(@RequestBody UserProfile userProfile) {
        UserProfile createdUserProfile = userProfileService.createUserProfile(userProfile);
        return ResponseEntity.ok(createdUserProfile);
    }

    @GetMapping
    public ResponseEntity<List<UserProfile>> getAllUserProfiles() {
        List<UserProfile> userProfiles = userProfileService.getAllUserProfiles();
        return ResponseEntity.ok(userProfiles);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserProfile> getUserProfileById(@PathVariable String id) {
        UserProfile userProfile = userProfileService.getUserProfileById(id);
        return ResponseEntity.ok(userProfile);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserProfile> updateUserProfile(@PathVariable String id, @RequestBody UserProfile userProfileDetails) {
        UserProfile updatedUserProfile = userProfileService.updateUserProfile(id, userProfileDetails);
        return ResponseEntity.ok(updatedUserProfile);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserProfile(@PathVariable String id) {
        userProfileService.deleteUserProfile(id);
        return ResponseEntity.noContent().build();
    }
}
