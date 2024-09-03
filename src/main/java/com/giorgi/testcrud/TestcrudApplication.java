package com.giorgi.testcrud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.giorgi.testcrud.services.UserRepository;

@SpringBootApplication
@EnableMongoRepositories
public class TestcrudApplication implements CommandLineRunner{

	@Autowired
	UserRepository userRepo;

	public void run(String... args){
		System.out.println("User count: " + userRepo.count());
	}

	public static void main(String[] args) {
		SpringApplication.run(TestcrudApplication.class, args);
	}

}
