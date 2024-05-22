package com.vanavil.monitorresourcesapi.controller;

import java.util.Calendar;
import java.util.List;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.vanavil.monitorresourcesapi.model.MonitorLog;

@RestController
@RequestMapping("/api/batch")
public class BatchProcessController {

	@SuppressWarnings("unchecked")
	@GetMapping("/monitorlogutils")
	public void runBatchProcess() {

		// Implement your batch process logic here
		final String uri = "http://localhost:8080/monitor-logs";
		long millisStart = Calendar.getInstance().getTimeInMillis();
		System.out.println("Batch process started.");
		RestTemplate restTemplate = new RestTemplate();
		List<MonitorLog> response = (List<MonitorLog>) restTemplate.getForObject(uri, MonitorLog.class);
		System.out.println("message recieved" + response);
		long millisEnd = Calendar.getInstance().getTimeInMillis();
		long responseTime = millisEnd - millisStart;
		System.out.println("Response Time : " + responseTime + "response : " + response);
		System.out.println("Batch process completed.");

	}

	@Scheduled(cron = "0 * * * * *")
	public void scheduledBatchProcess() {
		runBatchProcess();
	}
}
