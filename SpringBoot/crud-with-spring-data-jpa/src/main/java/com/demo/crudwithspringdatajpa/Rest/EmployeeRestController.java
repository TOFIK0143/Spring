package com.demo.crudwithspringdatajpa.Rest;


import com.demo.crudwithspringdatajpa.Entity.Employee;
import com.demo.crudwithspringdatajpa.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    @Autowired
    private EmployeeService employeeService;


    @GetMapping("/employee")
    public List<Employee> findAll()
    {
        return employeeService.findAll();
    }

    @GetMapping("/employee/{ID}")
    public Optional<Employee> findById(@PathVariable int ID)
    {
        return Optional.ofNullable(employeeService.findById(ID));
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
        employeeService.deleteById(Id);

        return "Deleted employee id - " + Id;
    }
}
