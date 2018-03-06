package com.sai.jpa.hibernate.jpahibernateadvancedemo1.repository;

import com.sai.jpa.hibernate.jpahibernateadvancedemo1.JpaHibernateAdvanceDemo1Application;
import com.sai.jpa.hibernate.jpahibernateadvancedemo1.entity.Course;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=JpaHibernateAdvanceDemo1Application.class)
public class NativeQueriesTest {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	EntityManager entityManager;
	
	@Test
	public void native_queries_basic() {
		Query query = entityManager.createNativeQuery("select * from course_details", Course.class);
		List<Course> courses = query.getResultList();
		logger.info("select * from course_details -> {}", courses);
	}

	@Test
	public void native_queries_where_with_parameter() {
//		Query query = entityManager.createNativeQuery("select * from course_details where id = 10001", Course.class);
		Query query = entityManager.createNativeQuery("select * from course_details where id = ?", Course.class);
		query.setParameter(1, 10001);
		List<Course> courses = query.getResultList();
		logger.info("select * from course_details where id = ? -> {}", courses);
	}

	@Test
	public void native_queries_where_with_named_parameter() {
		Query query = entityManager.createNativeQuery("select * from course_details where id = :id", Course.class);
		query.setParameter("id", 10001);
		List<Course> courses = query.getResultList();
		logger.info("select * from course_details where id = :id -> {}", courses);
	}

	@Test
	@Transactional
	public void native_queries_where_with_update() {
		Query query = entityManager.createNativeQuery("update course_details set last_updated_date = sysdate()", Course.class);
		int noOfRowsUpdated = query.executeUpdate();
		logger.info("update course_details set last_updated_date = sysdate() -> {}", noOfRowsUpdated);
	}

}
