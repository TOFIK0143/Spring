package com.demo.SpringBoot.CURDDemo.Rest;

import com.demo.SpringBoot.CURDDemo.DAO.EmployeeDAO;
import com.demo.SpringBoot.CURDDemo.Entity.Employee;
import com.demo.SpringBoot.CURDDemo.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    @Autowired
    private EmployeeService  employeeService;


    @GetMapping("/employee")
    public List<Employee> findAll()
    {
        return employeeService.findAll();
    }

    @GetMapping("/employee/{ID}")
    public Employee findById(@PathVariable int ID)
    {
        return employeeService.findById(ID);
    }

   @PostMapping("/employee")
    public Employee save(@RequestBody Employee employee) {

        return employeeService.save(employee);
    }

    // add mapping for PUT /employees - update existing employee

    @PutMapping("/employee")
    public Employee updateEmployee(@RequestBody Employee theEmployee) {

        return employeeService.save(theEmployee);
    }

   @DeleteMapping("/employee/{Id}")
    public String Delete(@PathVariable int Id) {
        return employeeService.Delete(Id);
    }
}
