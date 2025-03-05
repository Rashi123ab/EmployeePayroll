package com.rashi.EmployeePayroll.employee.repository;

import com.rashi.EmployeePayroll.employee.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}