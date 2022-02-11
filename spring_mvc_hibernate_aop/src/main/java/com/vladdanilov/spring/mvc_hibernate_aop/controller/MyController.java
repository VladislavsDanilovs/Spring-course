package com.vladdanilov.spring.mvc_hibernate_aop.controller;

import com.vladdanilov.spring.mvc_hibernate_aop.dao.EmployeeDAO;
import com.vladdanilov.spring.mvc_hibernate_aop.entity.Employee;
import com.vladdanilov.spring.mvc_hibernate_aop.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MyController {

//    @Autowired
    private EmployeeService employeeService;

    @Autowired
    public MyController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @RequestMapping("/")
    public String showAllEmployees(Model model){

        List<Employee> allEmployees = employeeService.getAllEmployees();
        model.addAttribute("allEmps", allEmployees);

        return "all-employees";
    }

    @RequestMapping("/addNewEmployee")
    public String addNewEmployee(Model model){

        Employee employee = new Employee();
        model.addAttribute("employee", employee);

        return "employee-info";
    }
    @RequestMapping("/saveEmployee")
    //getting from form our attribute employee
    public String saveEmployee(@ModelAttribute("employee") Employee employee){

        employeeService.saveEmployee(employee);

        return "redirect:/";
    }

    @RequestMapping("/updateInfo")
    public String updateEmployee(@RequestParam("empId") int id, Model model){


        Employee employee = employeeService.getEmployee(id);
        //same attributeName as in addNewEmployee, because our view already working with attribute employee
        model.addAttribute("employee", employee);

        return "employee-info";
    }

    @RequestMapping("/deleteInfo")
    public String deleteEmployee(@RequestParam("empId") int id, Model model){
        employeeService.deleteEmployee(id);
        return "redirect:/";
    }
}
