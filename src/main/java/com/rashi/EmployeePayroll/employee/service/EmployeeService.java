package com.rashi.EmployeePayroll.employee.service;
import com.rashi.EmployeePayroll.employee.model.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Slf4j
@Service
public class EmployeeService {

    private final List<Employee> employeeList = new ArrayList<>();
    private long nextId = 1;  // Simulates an auto-increment ID

    public List<Employee> getAllEmployees() {
        System.out.println("Employees List: " + employeeList);
        return employeeList;
    }

    public Employee getEmployeeById(Long id) {
        return employeeList.stream()
                .filter(emp -> emp.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public Employee saveEmployee(Employee employee) {
        employee.setId(nextId++);  // Assign a unique ID
        employeeList.add(employee);
        return employee;
    }

    public boolean deleteEmployee(Long id) {
        Optional<Employee> employeeToRemove = employeeList.stream()
                .filter(emp -> emp.getId().equals(id))
                .findFirst();

        employeeToRemove.ifPresent(employeeList::remove);
        return employeeToRemove.isPresent();
    }
}
