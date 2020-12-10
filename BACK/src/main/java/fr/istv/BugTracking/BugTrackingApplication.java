package fr.istv.BugTracking;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableAutoConfiguration
@ComponentScan({"fr.istv.BugTracking.controller"})
@SpringBootApplication

@EnableSwagger2

public class BugTrackingApplication {

	public static void main(String[] args) {
		SpringApplication.run(BugTrackingApplication.class, args);
	}

}