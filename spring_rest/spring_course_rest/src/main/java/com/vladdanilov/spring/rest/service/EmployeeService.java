package com.vladdanilov.spring.rest.service;

import com.vladdanilov.spring.rest.entity.Employee;

import java.util.List;

public interface EmployeeService {
    //same name as EmployeeDAOImpl
    public List<Employee> getAllEmployees();

    public void saveEmployee(Employee employee);

    public Employee getEmployee(int id);

    public void deleteEmployee(int id);
}
