package com.sai.jpa.hibernate.jpahibernateadvancedemo1.entity;

import javax.persistence.*;

@Entity
public class Passport {

	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false)
	private String number;

	protected Passport() {

	}

	public Passport(String number) {
		this.number = number;
	}
	
	public Long getId() {
		return id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return "Passport	 [id=" + id + ", number=" + number + "]";
	}
	
	
	
}
