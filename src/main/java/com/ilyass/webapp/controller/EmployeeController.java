package com.ilyass.webapp.controller;

import com.ilyass.webapp.model.Employee;
import com.ilyass.webapp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @GetMapping("/")
    public String employees(Model model) {
        System.out.println("EmployeeController *** employees(Model)  ");

        Iterable<Employee> listEmployee = service.getEmployees();

        model.addAttribute("employees", listEmployee);

        return "home";
    }
}
