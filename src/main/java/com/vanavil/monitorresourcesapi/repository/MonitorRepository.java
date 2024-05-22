package com.vanavil.monitorresourcesapi.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.vanavil.monitorresourcesapi.model.Monitor;

public interface MonitorRepository extends MongoRepository<Monitor, String> {

    List<Monitor> findByWebsite(String website);

    @Query("{ availability: ?0 }")
    List<Monitor> getMonitorsByAvailability(boolean availability);
}