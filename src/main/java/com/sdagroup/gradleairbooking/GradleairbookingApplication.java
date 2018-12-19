package com.sdagroup.gradleairbooking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@EntityScan // creates all the tables after a scan
@EnableJpaAuditing
@SpringBootApplication
public class GradleairbookingApplication {
	public static void main(String[] args) {
		SpringApplication.run(GradleairbookingApplication.class, args);
	}

}

