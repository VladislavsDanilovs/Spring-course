package com.vladdanilov.spring.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@RequestMapping("/employee")
public class MyController {

    @RequestMapping("/")
    public String showMyView() {
        return "myView";
    }

    @RequestMapping("/askDetails")
    public String askEmployeeDetails(Model model) {

//        Employee emp = new Employee();
//        emp.setName("Viktor");
//        emp.setSurname("King");
//        emp.setSalary(250);

        model.addAttribute("employee", new Employee());
        return "ask-emp-details-view";
    }

//    @RequestMapping("/showDetails")
//    public String showEmpDetails(){
//        return "show-emp-details-view";
//    }

//    @RequestMapping("/showDetails")
//    public String showEmpDetails(HttpServletRequest request, Model model){
//
//        String empName = request.getParameter("employeeName");
//        empName = "Mr. "+ empName;
//        model.addAttribute("nameAttribute", empName);
//        model.addAttribute("description", " -student");
//
//        return "show-emp-details-view";
//    }

    @PostMapping("/showDetails")
    public String showEmpDetails(@Valid @ModelAttribute("employee") Employee emp
            , BindingResult bindingResult) {
        String viewTemplate = null;
        if (bindingResult.hasFieldErrors()) {
            viewTemplate = "ask-emp-details-view";
        } else {
            viewTemplate = "show-emp-details-view";
        }
        return viewTemplate;
    }
}
