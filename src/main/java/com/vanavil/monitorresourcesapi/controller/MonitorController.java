package com.vanavil.monitorresourcesapi.controller;

import org.springframework.web.bind.annotation.RestController;

import com.vanavil.monitorresourcesapi.model.Monitor;
import com.vanavil.monitorresourcesapi.service.MonitorService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@RestController
@RequestMapping("/monitors")

public class MonitorController {

    @Autowired
    private MonitorService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Monitor createMonitor(@RequestBody Monitor monitor) {
        return service.addMonitor(monitor);
    }

    @GetMapping
    public List<Monitor> getMonitors() {
        return service.findAllMonitors();
    }

    @GetMapping("/{monitorId}")
    public Monitor getMonitor(@PathVariable String monitorId) {
        return service.getMonitorByMonitorId(monitorId);
    }

    @GetMapping("/website/{website}")
    public List<Monitor> findTaskUsingSeverity(@PathVariable String website) {
        return service.getMonitorByWebsite(website);
    }

    @PutMapping
    public Monitor modifyMonitor(@RequestBody Monitor monitor) {
        return service.updateMonitor(monitor);
    }

    @DeleteMapping("/{monitorId}")
    public String deleteMonitor(@PathVariable String monitorId) {
        return service.deleteMonitor(monitorId);
    }
}
