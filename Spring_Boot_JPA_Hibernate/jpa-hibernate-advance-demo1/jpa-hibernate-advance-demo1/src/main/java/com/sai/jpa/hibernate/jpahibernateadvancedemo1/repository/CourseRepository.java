package com.sai.jpa.hibernate.jpahibernateadvancedemo1.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sai.jpa.hibernate.jpahibernateadvancedemo1.entity.Course;

@Repository
@Transactional
public class CourseRepository {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	EntityManager entityManager;
	
	public Course findById(Long id) {
		return entityManager.find(Course.class, id);
	}
	
	public Course save(Course course) {
		
		if(course.getId() == null) {
			entityManager.persist(course);
		}
		else {
			entityManager.merge(course);
		}
		
		return course;
		
	}
	
	public void deleteById(Long id) {
		Course course = findById(id);
		entityManager.remove(course);
	}
	
	public void playWithEntityManager_v1() {

//		logger.info("playWithEntityManager - start");
		
		Course course1 = new Course("React JS Course1");
		entityManager.persist(course1);
		
		Course course2 = new Course("Angular JS Course");
		entityManager.persist(course2);
		// Flush all changes to DB with changes so far using EntityManager flush
		entityManager.flush();
		
		// detaching course1 and course2 so that changes on then are no more tracked
//		entityManager.detach(course1);
//		entityManager.detach(course2);
		
		//Another way of detaching all objects is to use clear
//		entityManager.clear();
		
		course1.setName("React JS Course - updated");
		course2.setName("Angular JS Course - updated");
		
		//refresh with content from DB
		entityManager.refresh(course1);
		entityManager.refresh(course2);
		
		entityManager.flush();
		
	}

	public void playWithEntityManager_v2() {

//		logger.info("playWithEntityManager - start");

		Course course1 = new Course("React JS Course");
		entityManager.persist(course1);

		course1.setName(null);

//		entityManager.persist(course1);

		entityManager.flush();

	}

	public void playWithEntityManager_v3() {

		Course course1 = new Course("React JS Course");
		entityManager.persist(course1);

		Course course2 = entityManager.find(Course.class, 10001L);
		course2.setName(course2.getName() + " - Updated");

		entityManager.flush();

	}

	public void playWithEntityManager_v4() {

	}


}
