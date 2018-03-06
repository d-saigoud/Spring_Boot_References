package com.sai.jpa.hibernate.jpahibernateadvancedemo1.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

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
public class JPQLTest {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	EntityManager entityManager;
	
	@Test
	public void jpql_basic_v1() {
		Query query = entityManager.createQuery("select c from Course c");
		List courses = query.getResultList();
		logger.info("select c from Course c -> {}", courses);
	}

	@Test
	public void jpql_basic_v2() {
		Query query = entityManager.createNamedQuery("query_get_all_courses");
		List courses = query.getResultList();
		logger.info("select c from Course c -> {}", courses);
	}
	
	@Test
	public void jpql_typed_v1() {
		TypedQuery<Course> typedQuery = entityManager.createQuery("select c from Course c", Course.class);
		List<Course> courses = typedQuery.getResultList();
		logger.info("select c from Course c -> {}", courses);
	}

	@Test
	public void jpql_typed_v2() {
		TypedQuery<Course> typedQuery = entityManager.createNamedQuery("query_get_all_courses", Course.class);
		List<Course> courses = typedQuery.getResultList();
		logger.info("select c from Course c -> {}", courses);
	}
	
	@Test
	public void jpql_where_v1() {
		TypedQuery<Course> typedQuery = entityManager.createQuery("select c from Course c where name like '%Course'", Course.class);
		List<Course> courses = typedQuery.getResultList();
		logger.info("select c from Course c where name like '%Course' -> {}", courses);
	}

	@Test
	public void jpql_where_v2() {
		TypedQuery<Course> typedQuery = entityManager.createNamedQuery("query_get_all_courses_ending_with_course_in_name", Course.class);
		List<Course> courses = typedQuery.getResultList();
		logger.info("select c from Course c where name like '%Course' -> {}", courses);
	}
	
}
