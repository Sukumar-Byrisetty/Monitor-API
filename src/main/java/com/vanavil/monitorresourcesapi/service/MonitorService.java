package com.vanavil.monitorresourcesapi.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vanavil.monitorresourcesapi.model.Monitor;
import com.vanavil.monitorresourcesapi.repository.MonitorRepository;

@Service
public class MonitorService {

    @Autowired
    private MonitorRepository repository;

    // CRUD CREATE, READ, UPDATE, DELETE

    public Monitor addMonitor(Monitor Monitor) {
        Monitor.setMonitorId(UUID.randomUUID().toString().split("-")[0]);
        return repository.save(Monitor);
    }

    public List<Monitor> findAllMonitors() {
        return repository.findAll();
    }

    public Monitor getMonitorByMonitorId(String MonitorId) {
        return repository.findById(MonitorId).get();
    }

    public List<Monitor> getMonitorByWebsite(String website) {
        return repository.findByWebsite(website);
    }

    public List<Monitor> getMonitorsByAvailability(boolean availability) {
        return repository.getMonitorsByAvailability(availability);
    }

    public Monitor updateMonitor(Monitor MonitorRequest) {
        Monitor existingMonitor = repository.findById(MonitorRequest.getMonitorId()).get();
        existingMonitor.setAvailability(MonitorRequest.isAvailability());
        return repository.save(existingMonitor);
    }

    public String deleteMonitor(String monitorId) {
        repository.deleteById(monitorId);
        return monitorId + " Monitor deleted from dashboard";
    }
}
