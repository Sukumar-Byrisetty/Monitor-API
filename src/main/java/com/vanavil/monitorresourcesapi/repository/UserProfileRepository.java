package com.vanavil.monitorresourcesapi.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.vanavil.monitorresourcesapi.model.UserProfile;

public interface UserProfileRepository extends MongoRepository<UserProfile, String> {
}
