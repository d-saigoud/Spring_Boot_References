package com.sai.jpa.hibernate.jpahibernateadvancedemo1;

import com.sai.jpa.hibernate.jpahibernateadvancedemo1.entity.Student;
import com.sai.jpa.hibernate.jpahibernateadvancedemo1.repository.StudentRepository;
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
    private CourseRepository courseRepository;

    @Autowired
    private StudentRepository studentRepository;

	public static void main(String[] args) {
		SpringApplication.run(JpaHibernateAdvanceDemo1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

//		Course course = courseRepository.findById(10001L);
//		
//		logger.info("Course 10001 -> {}", course);
//		
//		courseRepository.save(new Course("New Course"));

//		courseRepository.playWithEntityManager_v3();
//		courseRepository.playWithEntityManager_v4();

        studentRepository.saveStudentWithPassport();

	}
}
