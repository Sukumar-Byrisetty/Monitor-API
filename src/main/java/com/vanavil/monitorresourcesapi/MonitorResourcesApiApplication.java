package com.vanavil.monitorresourcesapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class MonitorResourcesApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MonitorResourcesApiApplication.class, args);
	}

}
