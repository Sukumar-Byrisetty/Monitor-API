// UserRepository.java
package com.vanavil.monitorresourcesapi.repository;

import com.vanavil.monitorresourcesapi.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
    User findByMobileNumber(String mobileNumber);
}
