package com.home.demo.learning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan
public class SpringAngular4Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringAngular4Application.class, args);
	}
}
