package com.sai.databasedemo.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.sai.databasedemo.entity.Person;

@Repository
@Transactional
public class PersonJpaRepository {
	
	@PersistenceContext
	EntityManager entityManager;

	public List<Person> findAll() {
		TypedQuery<Person> namedQuery = entityManager.createNamedQuery("find_all_persons", Person.class);
		return namedQuery.getResultList();
	}
	
	public Person findById(int id) {
		return entityManager.find(Person.class, id);
	}
	
	public Person update(Person person) {
		// for update and insert we need to call merge method
		// If id is assigned in person then it would update it in database
		// If Id is not assigned in person then it would insert this new person
		return entityManager.merge(person);
	}
	
	public Person insert(Person person) {
		// for update and insert we need to call merge method
		// If id is assigned in person then it would update it in database
		// If Id is not assigned in person then it would insert this new person
		return entityManager.merge(person);
	}
	
	public void deleteById(int id) {
		Person person = findById(id);
		entityManager.remove(person);
	}
	
}
