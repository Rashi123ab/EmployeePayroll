package com.rashi.EmployeePayroll.employee.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double salary;

    // Constructors
    public Employee() {}
    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    // Getters and Setters
//    public Long getId() { return id; }
//    public void setId(Long id) { this.id = id; }
//
//    public String getName() { return name; }
//    public void setName(String name) { this.name = name; }
//
//    public double getSalary() { return salary; }
//    public void setSalary(double salary) { this.salary = salary; }
}

