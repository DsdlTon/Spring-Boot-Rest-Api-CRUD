package com.homepro.me.services;

import java.util.List;
import java.util.Optional;

import com.homepro.me.models.Employee;
import com.homepro.me.repository.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    final private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getEmployee() {
        return (List<Employee>) employeeRepository.findAll();
    }

    public Optional<Employee> getEmployeeById(int id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        return employee;
    }

    public void saveEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

}