package com.sai.jpa.hibernate.jpahibernateadvancedemo1.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="CourseDetails")
//@NamedQuery(name="query_get_all_courses", query="select c from Course c")
@NamedQueries(value = {
		@NamedQuery(name="query_get_all_courses", query="select c from Course c"),
		@NamedQuery(name="query_get_all_courses_ending_with_course_in_name", query="select c from Course c where name like '%Course'")
})
public class Course {

	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false)
	private String name;

	@UpdateTimestamp
	private LocalDateTime lastUpdatedDate;

	@CreationTimestamp
	private LocalDateTime createdDate;
	
	protected Course() {

	}
	
	public Course(String name) {
		this.name = name;
	}
	
	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}



	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + "]";
	}
	
	
	
}
