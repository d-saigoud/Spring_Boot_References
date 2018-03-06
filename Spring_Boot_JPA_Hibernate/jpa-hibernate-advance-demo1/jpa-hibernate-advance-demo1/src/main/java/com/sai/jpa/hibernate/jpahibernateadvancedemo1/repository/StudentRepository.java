package com.sai.jpa.hibernate.jpahibernateadvancedemo1.repository;

import com.sai.jpa.hibernate.jpahibernateadvancedemo1.entity.Passport;
import com.sai.jpa.hibernate.jpahibernateadvancedemo1.entity.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Repository
@Transactional
public class StudentRepository {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	EntityManager entityManager;
	
	public Student findById(Long id) {
		return entityManager.find(Student.class, id);
	}
	
	public Student save(Student student) {
		
		if(student.getId() == null) {
			entityManager.persist(student);
		}
		else {
			entityManager.merge(student);
		}
		
		return student;
		
	}
	
	public void deleteById(Long id) {
		Student student = findById(id);
		entityManager.remove(student);
	}
	
	public void playWithEntityManager_v1() {

//		logger.info("playWithEntityManager - start");
		
		Student Student1 = new Student("React JS Student1");
		entityManager.persist(Student1);
		
		Student Student2 = new Student("Angular JS Student");
		entityManager.persist(Student2);
		// Flush all changes to DB with changes so far using EntityManager flush
		entityManager.flush();
		
		// detaching Student1 and Student2 so that changes on then are no more tracked
//		entityManager.detach(Student1);
//		entityManager.detach(Student2);
		
		//Another way of detaching all objects is to use clear
//		entityManager.clear();
		
		Student1.setName("React JS Student - updated");
		Student2.setName("Angular JS Student - updated");
		
		//refresh with content from DB
		entityManager.refresh(Student1);
		entityManager.refresh(Student2);
		
		entityManager.flush();
		
	}

	public void playWithEntityManager_v2() {

//		logger.info("playWithEntityManager - start");

		Student student1 = new Student("React JS Student");
		entityManager.persist(student1);

		student1.setName(null);

//		entityManager.persist(Student1);

		entityManager.flush();

	}

	public void playWithEntityManager_v3() {

		Student student1 = new Student("React JS Student");
		entityManager.persist(student1);

		Student student2 = entityManager.find(Student.class, 10001L);
		student2.setName(student2.getName() + " - Updated");

		entityManager.flush();

	}

	public void saveStudentWithPassport() {
		Passport passport = new Passport("Z123456");
		entityManager.persist(passport);

		Student student = new Student("Ryan");
		student.setPassport(passport);
		entityManager.persist(student);

	}

	public void someDummyOperation() {
		//Database Operation 1 - Retrieve Student
		Student student = entityManager.find(Student.class, 20001L);

		//Database Operation 2 - Retrieve Passport
		Passport passport = student.getPassport();

		//Database Operation 3 - Update Passport
		passport.setNumber("M123456");


		//Database Operation 4 - Update Student
		student.setName(student.getName() + " - Updated");
	}




}
