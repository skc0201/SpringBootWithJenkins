package com.springboot.mongodb.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories("com.springboot.mongodb.demo.repository")
public class SpringBootWithMongodbApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootWithMongodbApplication.class, args);
	}

}
