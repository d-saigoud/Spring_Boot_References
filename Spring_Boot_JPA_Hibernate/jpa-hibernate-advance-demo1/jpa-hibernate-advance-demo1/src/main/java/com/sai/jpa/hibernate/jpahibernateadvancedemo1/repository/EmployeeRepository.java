package com.sai.jpa.hibernate.jpahibernateadvancedemo1.repository;

import com.sai.jpa.hibernate.jpahibernateadvancedemo1.entity.Course;
import com.sai.jpa.hibernate.jpahibernateadvancedemo1.entity.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class EmployeeRepository {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	EntityManager entityManager;

	//insert an employee
	public void insert(Employee employee) {
		entityManager.persist(employee);
	}

	//retrieve all employees
	
	public List<Employee> retrieveAllEmployees() {
		return entityManager.createQuery("select e from employee e", Employee.class).getResultList();
	}
	


}
