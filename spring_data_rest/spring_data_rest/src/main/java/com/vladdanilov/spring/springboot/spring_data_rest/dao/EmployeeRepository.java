package com.vladdanilov.spring.springboot.spring_data_rest.dao;

import com.vladdanilov.spring.springboot.spring_data_rest.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//First generic is entity type, second is type of primary key, in our case int id, so its Integer
public interface EmployeeRepository extends JpaRepository<Employee, Integer>  {
    public List<Employee> findAllByName(String name);

}
