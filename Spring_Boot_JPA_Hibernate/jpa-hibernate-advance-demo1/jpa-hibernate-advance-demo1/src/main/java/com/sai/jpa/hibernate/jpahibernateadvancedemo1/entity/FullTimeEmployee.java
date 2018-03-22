package com.sai.jpa.hibernate.jpahibernateadvancedemo1.entity;

import java.math.BigDecimal;

public class FullTimeEmployee extends Employee {
    private BigDecimal salary;

    protected FullTimeEmployee() {
    }

    public FullTimeEmployee(String name, BigDecimal salary) {
        super(name);
        this.salary = salary;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }
}
