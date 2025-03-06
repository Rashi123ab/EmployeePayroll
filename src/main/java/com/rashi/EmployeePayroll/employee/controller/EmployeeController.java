package com.rashi.EmployeePayroll.employee.controller;


import com.rashi.EmployeePayroll.employee.DTO.EmployeeDTO;
import com.rashi.EmployeePayroll.employee.model.Employee;
import com.rashi.EmployeePayroll.employee.repository.EmployeeRepository;
import com.rashi.EmployeePayroll.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @GetMapping
    public List<EmployeeDTO> getAllEmployees() {
        return service.getAllEmployees();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable Long id) {
        EmployeeDTO employeeDTO = service.getEmployeeById(id);
        return employeeDTO != null ? ResponseEntity.ok(employeeDTO) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public EmployeeDTO addEmployee(@RequestBody EmployeeDTO employeeDTO) {
        return service.saveEmployee(employeeDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        service.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }
}