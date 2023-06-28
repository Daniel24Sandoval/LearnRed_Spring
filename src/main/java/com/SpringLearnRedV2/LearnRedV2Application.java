package com.SpringLearnRedV2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
@ComponentScan(basePackages = {"com.SpringLearnRedV2"})
@SpringBootApplication
public class LearnRedV2Application {

	public static void main(String[] args) {
		SpringApplication.run(LearnRedV2Application.class, args);
	}

}
