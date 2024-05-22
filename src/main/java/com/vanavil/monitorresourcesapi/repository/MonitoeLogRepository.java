package com.vanavil.monitorresourcesapi.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.vanavil.monitorresourcesapi.model.MonitorLog;

import java.util.List;

public interface MonitoeLogRepository extends MongoRepository<MonitorLog,String> {

    List<MonitorLog> findByWebsite(String website);

    @Query("{ availability: ?0 }")
    List<MonitorLog> getMonitorLogsByAvailability(boolean availability);
}