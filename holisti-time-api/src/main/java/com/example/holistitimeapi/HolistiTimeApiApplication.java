package com.example.holistitimeapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.example.holistitimeapi")
public class HolistiTimeApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(HolistiTimeApiApplication.class, args);
	}

}
