package fr.istv.BugTracking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.HttpMediaTypeNotSupportedException;

@Configuration
@EnableAutoConfiguration
@ComponentScan({"fr.istv.BugTracking.controller"})
@SpringBootApplication


public class BugTrackingApplication {

	public static void main(String[] args) {
		SpringApplication.run(BugTrackingApplication.class, args);
	}

}