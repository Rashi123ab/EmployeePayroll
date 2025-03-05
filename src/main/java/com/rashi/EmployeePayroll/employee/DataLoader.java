package com.rashi.EmployeePayroll.employee;

import com.rashi.EmployeePayroll.employee.model.Employee;
import com.rashi.EmployeePayroll.employee.repository.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component  // Marks this as a startup component
public class DataLoader implements CommandLineRunner {

    private final EmployeeRepository employeeRepository;

    public DataLoader(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void run(String... args) {
        // Adding sample employees
        employeeRepository.save(new Employee(null, "Alice", "HR", 50000));
        employeeRepository.save(new Employee(null, "Bob", "IT", 70000));
    }
}