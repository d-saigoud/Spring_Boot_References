package com.sai.jpa.hibernate.jpahibernateadvancedemo1.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.sai.jpa.hibernate.jpahibernateadvancedemo1.JpaHibernateAdvanceDemo1Application;
import com.sai.jpa.hibernate.jpahibernateadvancedemo1.entity.Course;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=JpaHibernateAdvanceDemo1Application.class)
public class CourseRepositoryTest {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	CourseRepository repository;
	
	
	
	@Test
	@DirtiesContext
	public void deleteById_basic() {
		repository.deleteById(10002L);
		assertNull(repository.findById(10002L));
	}
	
	@Test
	public void findById_basic() {
		Course course = repository.findById(10002L);
		assertEquals("Course 2", course.getName());
	}
	
	@Test
	@DirtiesContext
	public void save_basic() {
		Course course = repository.findById(10002L);
		assertEquals("Course 2", course.getName());
		course.setName("New Updated Course");
		repository.save(course);
		Course course1 = repository.findById(10002L);
		assertEquals("New Updated Course", course1.getName());
	}
	
	@Test
	@DirtiesContext
	public void playWithEntityManager() {
//		repository.playWithEntityManager_v1();
		repository.playWithEntityManager_v2();
	}

}
