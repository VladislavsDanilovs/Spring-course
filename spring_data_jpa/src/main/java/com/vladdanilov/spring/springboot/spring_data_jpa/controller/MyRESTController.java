package com.vladdanilov.spring.springboot.spring_data_jpa.controller;

import com.vladdanilov.spring.springboot.spring_data_jpa.entity.Employee;
import com.vladdanilov.spring.springboot.spring_data_jpa.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyRESTController {

    private EmployeeService employeeService;

    @Autowired
    public MyRESTController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> showAllEmployees() {
        List<Employee> allEmployees = employeeService.getAllEmployees();
        return allEmployees;
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable int id) {
        Employee employee = employeeService.getEmployee(id);

        return employee;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);
        return employee;
    }

    @PutMapping("/employees")
    public Employee editEmployee(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);
        return employee;
    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable int id) {
        getEmployee(id);

        employeeService.deleteEmployee(id);
        return "Employee with ID " + id + " was deleted";
    }

    @GetMapping("/employees/name/{name}")
    public List<Employee> findEmployeeByName(@PathVariable String name){
        List<Employee> employees = employeeService.finaAllByName(name);
        return employees;
    }

}
