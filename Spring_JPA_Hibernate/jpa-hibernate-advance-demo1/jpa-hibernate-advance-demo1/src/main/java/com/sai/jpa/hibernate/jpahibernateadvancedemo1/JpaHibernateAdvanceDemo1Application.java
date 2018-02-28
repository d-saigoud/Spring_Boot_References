package com.sai.jpa.hibernate.jpahibernateadvancedemo1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sai.jpa.hibernate.jpahibernateadvancedemo1.entity.Course;
import com.sai.jpa.hibernate.jpahibernateadvancedemo1.repository.CourseRepository;

@SpringBootApplication
public class JpaHibernateAdvanceDemo1Application implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass()); 
	
	@Autowired
	private CourseRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(JpaHibernateAdvanceDemo1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Course course = repository.findById(10001L);
		
		logger.info("Course 10001 -> {}", course);
		
	}
}
