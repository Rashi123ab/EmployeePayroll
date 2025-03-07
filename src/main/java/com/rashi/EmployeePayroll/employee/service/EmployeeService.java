package com.rashi.EmployeePayroll.employee.service;

import com.rashi.EmployeePayroll.employee.DTO.EmployeeDTO;
import com.rashi.EmployeePayroll.employee.model.Employee;
import com.rashi.EmployeePayroll.employee.repository.EmployeeRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    public List<EmployeeDTO> getAllEmployees() {
        return repository.findAll()
                .stream()
                .map(emp -> new EmployeeDTO(emp.getName(), emp.getSalary()))
                .collect(Collectors.toList());
    }

    public EmployeeDTO getEmployeeById(Long id) {
        return repository.findById(id)
                .map(emp -> new EmployeeDTO(emp.getName(), emp.getSalary()))
                .orElse(null);
    }

    public EmployeeDTO saveEmployee(@Valid EmployeeDTO employeeDTO) {
        Employee employee = new Employee(employeeDTO.getName(), employeeDTO.getSalary());
        Employee savedEmployee = repository.save(employee);
        return new EmployeeDTO(savedEmployee.getName(), savedEmployee.getSalary());
    }

    public EmployeeDTO updateEmployee(Long id, @Valid EmployeeDTO employeeDTO) {
        Optional<Employee> existingEmployee = repository.findById(id);

        if (existingEmployee.isPresent()) {
            Employee employee = existingEmployee.get();
            employee.setName(employeeDTO.getName());
            employee.setSalary(employeeDTO.getSalary());
            Employee updatedEmployee = repository.save(employee);
            return new EmployeeDTO(updatedEmployee.getName(), updatedEmployee.getSalary());
        }
        return null;
    }

    public void deleteEmployee(Long id) {
        repository.deleteById(id);
    }
}
