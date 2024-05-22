package com.vanavil.monitorresourcesapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vanavil.monitorresourcesapi.model.MonitorLog;
import com.vanavil.monitorresourcesapi.repository.MonitoeLogRepository;

import java.util.List;
import java.util.UUID;

@Service
public class MonitorLogService {

    @Autowired
    private MonitoeLogRepository repository;

    // CRUD CREATE , READ , UPDATE , DELETE

    public MonitorLog addMonitorLog(MonitorLog MonitorLog) {
        MonitorLog.setMonitorLogId(UUID.randomUUID().toString().split("-")[0]);
        return repository.save(MonitorLog);
    }

    public List<MonitorLog> findAllMonitorLogs() {
        return repository.findAll();
    }

    public MonitorLog getMonitorLogByMonitorLogId(String MonitorLogId) {
        return repository.findById(MonitorLogId).get();
    }

    public List<MonitorLog> getMonitorLogByWebsite(String website) {
        return repository.findByWebsite(website);
    }

    public List<MonitorLog> getMonitorLogsByAvailability(boolean availability) {
        return repository.getMonitorLogsByAvailability(availability);
    }

    public MonitorLog updateMonitorLog(MonitorLog MonitorLogRequest) {
        // get the existing document from DB
        // populate new value from request to existing object/entity/document
        MonitorLog existingMonitorLog = repository.findById(MonitorLogRequest.getMonitorLogId()).get();
        existingMonitorLog.setAvailability(MonitorLogRequest.isAvailability());
        // existingMonitorLog.setSeverity(MonitorLogRequest.getSeverity());
        // existingMonitorLog.setAssignee(MonitorLogRequest.getAssignee());
        // existingMonitorLog.setStoryPoint(MonitorLogRequest.getStoryPoint());
        return repository.save(existingMonitorLog);
    }

    public String deleteMonitorLog(String monitorLogId) {
        repository.deleteById(monitorLogId);
        return monitorLogId + " MonitorLog deleted from dashboard ";
    }
}