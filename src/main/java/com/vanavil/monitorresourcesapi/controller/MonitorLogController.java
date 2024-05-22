package com.vanavil.monitorresourcesapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.vanavil.monitorresourcesapi.model.MonitorLog;
import com.vanavil.monitorresourcesapi.service.MonitorLogService;

import java.util.List;

@RestController
@RequestMapping("/monitor-logs")
public class MonitorLogController {

    @Autowired
    private MonitorLogService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MonitorLog creatMonitorLog(@RequestBody MonitorLog monitorLog) {
        return service.addMonitorLog(monitorLog);
    }

    @GetMapping
    public List<MonitorLog> getMonitorLogs() {
        return service.findAllMonitorLogs();
    }

    @GetMapping("/{monitorLogId}")
    public MonitorLog getMonitorLog(@PathVariable String monitorLogId) {
        return service.getMonitorLogByMonitorLogId(monitorLogId);
    }

    @GetMapping("/website/{website}")
    public List<MonitorLog> findTaskUsingSeverity(@PathVariable String website) {
        return service.getMonitorLogByWebsite(website);
    }

    /*
     * @GetMapping("/assignee/{assignee}")
     * public List<Task> getTaskByAssignee(@PathVariable String assignee){
     * return service.getTaskByAssignee(assignee);
     * }
     */

    @PutMapping
    public MonitorLog modifyMonitorLog(@RequestBody MonitorLog monitorLog) {
        return service.updateMonitorLog(monitorLog);
    }

    @DeleteMapping("/{monitorLogId}")
    public String deleteMonitorLog(@PathVariable String monitorLogId) {
        return service.deleteMonitorLog(monitorLogId);
    }
}