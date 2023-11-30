package com.spring.stock.spot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class StockSpotApplication {

	public static void main(String[] args) {
		SpringApplication.run(StockSpotApplication.class, args);
	}

}
