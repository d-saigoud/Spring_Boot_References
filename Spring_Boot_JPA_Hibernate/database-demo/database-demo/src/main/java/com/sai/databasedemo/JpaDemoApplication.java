package com.sai.databasedemo;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Repository;

import com.sai.databasedemo.entity.Person;
import com.sai.databasedemo.jdbc.PersonJdbcDao;
import com.sai.databasedemo.jpa.PersonJpaRepository;

@SpringBootApplication
public class JpaDemoApplication implements CommandLineRunner {

	private Logger logger  = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	PersonJpaRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(JpaDemoApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		logger.info("All users -> {}", repository.findAll());
		logger.info("User by id 10001 -> {}", repository.findById(10001));
//		logger.info("User by name 'Sai' -> {}", repository.findByName("Sai"));
//		logger.info("User by location 'Hyderabad' -> {}", repository.findByLocation("Hyderabad"));
//		logger.info("Deleting User id 10002 -> No of rows deleted {}", repository.deleteById(10002));
		logger.info("Inserting a new User with id 10004 -> {}", 
				repository.insert(new Person("Sam", "Cleveland", new Date())));
		logger.info("Updating User with id 10003 -> {}", 
				repository.update(new Person(10003, "Cole", "Indianapolis", new Date())));
		repository.deleteById(10002);
		logger.info("All users now -> {}", repository.findAll());
	}
}
