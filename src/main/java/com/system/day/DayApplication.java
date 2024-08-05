package com.system.day;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.system.day", "utils"})
public class DayApplication {

	public static void main(String[] args) {
		SpringApplication.run(DayApplication.class, args);
	}

}
