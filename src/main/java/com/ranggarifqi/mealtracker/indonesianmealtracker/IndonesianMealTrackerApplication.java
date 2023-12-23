package com.ranggarifqi.mealtracker.indonesianmealtracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.Clock;

@SpringBootApplication
public class IndonesianMealTrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(IndonesianMealTrackerApplication.class, args);
	}

	@Bean
	Clock clock() {
		return Clock.systemUTC();
	}
}
