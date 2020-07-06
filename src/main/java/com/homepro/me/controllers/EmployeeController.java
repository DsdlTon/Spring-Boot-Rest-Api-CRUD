package com.homepro.me.controllers;

import java.util.List;
import java.util.Optional;

import com.homepro.me.models.Employee;
import com.homepro.me.repository.EmployeeRepository;
import com.homepro.me.services.EmployeeService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/emp")
public class EmployeeController {

    final EmployeeService employeeService;
    final EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeService employeeService, EmployeeRepository employeeRepository) {
        this.employeeService = employeeService;
        this.employeeRepository = employeeRepository;
    }

    // Find All Employee
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Employee>> getEmployee() {
        return new ResponseEntity<>(employeeService.getEmployee(), HttpStatus.OK);
    }

    // Add New Employee
    @RequestMapping(method = RequestMethod.POST)
    public String addEmployee(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);
        return employee.toString();
    }

    // Find Employee By ID
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity<Optional<Employee>> getEmployeeById(@PathVariable(value = "id") int id) {
        return new ResponseEntity<>(employeeService.getEmployeeById(id), HttpStatus.OK);
    }

    // Update Employee
    @RequestMapping(method = RequestMethod.PUT, value = "/update/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") int id,
                                         @RequestBody Employee employee) {
        Optional<Employee> employeeData = employeeService.getEmployeeById(id);
        if (employeeData.isPresent()) {
            Employee _employee = employeeData.get();
            _employee.setName(employee.getName());
            _employee.setPosition(employee.getPosition());
            _employee.setDepartment(employee.getDepartment());
            _employee.setSalary(employee.getSalary());
            return new ResponseEntity<>(employeeRepository.save(_employee), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable("id") int id) {
        try {
            employeeRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

}
