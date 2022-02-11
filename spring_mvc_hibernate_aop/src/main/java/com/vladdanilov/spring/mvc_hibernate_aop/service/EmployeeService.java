package com.vladdanilov.spring.mvc_hibernate_aop.service;

import com.vladdanilov.spring.mvc_hibernate_aop.entity.Employee;

import java.util.List;

public interface EmployeeService {
    //same name as EmployeeDAOImpl
    public List<Employee> getAllEmployees();

    public void saveEmployee(Employee employee);

    public Employee getEmployee(int id);

    public void deleteEmployee(int id);
}
