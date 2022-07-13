package com.demo.thymeleafDemocurd.controller;



import com.demo.thymeleafDemocurd.Entity.Employee;
import com.demo.thymeleafDemocurd.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;


    @GetMapping("/list")
    public String listEmployees(Model model)
    {
        List<Employee> employeeList = employeeService.findAll();

        model.addAttribute("employees",employeeList);
        return "list-employees";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model)
    {
        // create model attribute to bind form data
        Employee theEmployee = new Employee();

        model.addAttribute("employee", theEmployee);

        return "employee-form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("employee") Employee theEmployee )
    {
        employeeService.save(theEmployee);
        return "redirect:/employees/list";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("employeeId") int id, Model model)
    {
        Employee employee = employeeService.findById(id);
        model.addAttribute("employee",employee);
        return "employee-form";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("employeeId") int id)
    {
        employeeService.deleteById(id);

        return "redirect:/employees/list";
    }




}
